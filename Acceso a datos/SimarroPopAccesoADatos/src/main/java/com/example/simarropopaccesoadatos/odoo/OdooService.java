package com.example.simarropopaccesoadatos.odoo;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class OdooService {

    private static final String HOST = "odoogrupoe.com";
    private static final String DB = "simarropop";
    private static final String USER = "admin@gmail.com";
    private static final String PASS = "admin";
    private static final String JSON_RPC_URL = "http://" + HOST + "/jsonrpc";

    private final RestTemplate restTemplate;

    public OdooService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Metodo para realizar una llamada JSON-RPC
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
            throw new RuntimeException("Error en la llamada JSON-RPC: " + responseBody.get("error"));
        }

        return responseBody != null ? responseBody.get("result") : null;
    }

    // Metodo para llamar a un servicio específico
    private Object call(String service, String method, Object... args) {
        Map<String, Object> params = new HashMap<>();
        params.put("service", service);
        params.put("method", method);
        params.put("args", args);
        return jsonRpcCall("call", params);
    }

    // Metodo para obtener la lista de clientes
    public List<Object> getClients() {
        // Autenticación
        int uid = (int) call("common", "login", DB, USER, PASS);

        // Obtener lista de clientes
        Object[] args = new Object[]{};
        return (List<Object>) call("object", "execute", DB, uid, PASS, "res.partner", "search", args);
    }
}

