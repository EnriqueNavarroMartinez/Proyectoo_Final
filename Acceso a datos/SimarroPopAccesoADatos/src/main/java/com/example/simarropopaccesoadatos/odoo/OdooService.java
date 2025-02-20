package com.example.simarropopaccesoadatos.odoo;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OdooService {

    private static final String HOST = "odoogrupoe.com";
    private static final String DB = "proyecto3";
    private static final String USER = "admin";
    private static final String PASS = "admin";
    private static final String JSON_RPC_URL = "http://" + HOST + "/jsonrpc";

    private final RestTemplate restTemplate;

    public OdooService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Mètode per realitzar una crida JSON-RPC
    private Object jsonRpcCall(String method, Map<String, Object> params) {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("jsonrpc", "2.0");
        requestBody.put("method", method);
        requestBody.put("params", params);
        requestBody.put("id", new Random().nextInt(1000000000));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(JSON_RPC_URL, requestEntity, Map.class);
        Map<String, Object> responseBody = response.getBody();

        if (responseBody != null && responseBody.containsKey("error")) {
            throw new RuntimeException("Error en la crida JSON-RPC: " + responseBody.get("error"));
        }

        return responseBody != null ? responseBody.get("result") : null;
    }

    // Metode per cridar a un servei específic
    private Object call(String service, String method, Object... args) {
        Map<String, Object> params = new HashMap<>();
        params.put("service", service);
        params.put("method", method);
        params.put("args", args);
        return jsonRpcCall("call", params);
    }

    // Metodo para crear clientes, realizar una compra y generar una factura en Odoo
    public void createClientAndPurchase(List<Map<String, Object>> clients, List<Map<String, Object>> products) {
        // Autenticación
        int uid = (int) call("common", "login", DB, USER, PASS);

        // Crear clientes en el modelo res.partner
        for (Map<String, Object> client : clients) {
            int partnerId = (int) call("object", "execute", DB, uid, PASS, "res.partner", "create", client);

            // Crear una orden de venta (sale.order)
            Map<String, Object> saleOrder = new HashMap<>();
            saleOrder.put("partner_id", partnerId); // Asociar el cliente
            saleOrder.put("order_line", createOrderLines(products)); // Añadir líneas de pedido

            int saleOrderId = (int) call("object", "execute", DB, uid, PASS, "sale.order", "create", saleOrder);

            // Confirmar la orden de venta
            call("object", "execute", DB, uid, PASS, "sale.order", "action_confirm", saleOrderId);

            // Generar la factura (Odoo lo hace automáticamente al confirmar la orden)
            // Si necesitas personalizar la factura, puedes usar el modelo account.move
        }
    }

    // Metodo para crear líneas de pedido
    private List<Object> createOrderLines(List<Map<String, Object>> products) {
        List<Object> orderLines = new ArrayList<>();

        for (Map<String, Object> product : products) {
            Map<String, Object> orderLine = new HashMap<>();
            orderLine.put("product_id", product.get("product_id")); // ID del producto
            orderLine.put("product_uom_qty", product.get("quantity")); // Cantidad
            orderLine.put("price_unit", product.get("price")); // Precio unitario
            orderLines.add(new Object[]{0, 0, orderLine});
        }

        return orderLines;
    }
}