package com.example.simarropopaccesoadatos.odoo;

import com.example.simarropopaccesoadatos.odoo.OdooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/odoo")
public class OdooController {

    @Autowired
    private OdooService odooService;

    @GetMapping("/clients")
    public List<Object> getClients() {
        return odooService.getClients();
    }
}
