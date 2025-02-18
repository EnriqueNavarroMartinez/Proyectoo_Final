package com.example.simarropopaccesoadatos.odoo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OdooClient {

    private static final String HOST = "localhost";
    private static final int PORT = 8069;
    private static final String DB = "simarropop";
    private static final String USER = "admin";
    private static final String PASS = "admin";

    private static final String JSON_RPC_URL = "http://" + HOST + ":" + PORT + "/jsonrpc";

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {
        String uid = login();
        System.out.println("Logged in with UID: " + uid);

        // Example: Search for clients
        Object[] clients = execute("res.partner", "search", new Object[]{});
        System.out.println("Clients: " + Arrays.toString(clients));
    }

    private static String login() throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("db", DB);
        params.put("login", USER);
        params.put("password", PASS);

        Map<String, Object> result = jsonRpcCall("common", "login", params);
        return (String) result.get("result");
    }

    private static Object[] execute(String model, String method, Object[] args) throws Exception {
        Map<String, Object> params = new HashMap<>();
        params.put("model", model);
        params.put("method", method);
        params.put("args", args);

        Map<String, Object> result = jsonRpcCall("object", "execute", params);
        return (Object[]) result.get("result");
    }

    private static Map<String, Object> jsonRpcCall(String service, String method, Map<String, Object> params) throws Exception {
        Map<String, Object> request = new HashMap<>();
        request.put("jsonrpc", "2.0");
        request.put("method", "call");
        request.put("params", params);
        request.put("id", new Random().nextInt(1000000000));

        String jsonRequest = objectMapper.writeValueAsString(request);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(JSON_RPC_URL);
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setEntity(new StringEntity(jsonRequest));

            HttpResponse response = httpClient.execute(httpPost);
            String jsonResponse = EntityUtils.toString(response.getEntity());

            return objectMapper.readValue(jsonResponse, Map.class);
        }
    }
}
