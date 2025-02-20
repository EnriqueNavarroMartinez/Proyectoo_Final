package com.example.simarropopaccesoadatos.odoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/odoo")
public class OdooController {

    @Autowired
    private OdooService odooService;

    // Endpoint para crear un cliente en Odoo
    @PostMapping("/clientes")
    public String createClientsAndPurchase(@RequestBody RequestData requestData) {
        try {
            odooService.createClientAndPurchase(requestData.getClients(), requestData.getProducts());
            return "Clients creats i compra realitzada amb èxit.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error en crear clients o realitzar la compra: " + e.getMessage();
        }
    }

    // Classe interna per mapejar la petició JSON
    public static class RequestData {
        private List<Map<String, Object>> clients;
        private List<Map<String, Object>> products;

        public List<Map<String, Object>> getClients() {
            return clients;
        }

        public void setClients(List<Map<String, Object>> clients) {
            this.clients = clients;
        }

        public List<Map<String, Object>> getProducts() {
            return products;
        }

        public void setProducts(List<Map<String, Object>> products) {
            this.products = products;
        }
    }
}
