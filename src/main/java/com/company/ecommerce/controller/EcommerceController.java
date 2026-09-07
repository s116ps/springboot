package com.company.ecommerce.controller;

import com.company.ecommerce.model.InventoryItem;
import com.company.ecommerce.model.OrderRecord;
import com.company.ecommerce.service.EcommerceService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class EcommerceController {
    private final EcommerceService ecommerceService;

    @Autowired
    public EcommerceController(EcommerceService ecommerceService) {
        this.ecommerceService = ecommerceService;
    }

    @PostMapping({"/inventory"})
    public ResponseEntity<InventoryItem> addInventory(@RequestBody InventoryItem item) {
        return ResponseEntity.ok(this.ecommerceService.addOrUpdateInventory(item));
    }

    @GetMapping
    public ResponseEntity<List<InventoryItem>> getInventory() {
        return ResponseEntity.ok(this.ecommerceService.getAllInventory());
    }

    public ResponseEntity<?> placeOrder(@RequestBody Map<String, Object> payload) {
        try {
            String sku = (String)payload.get("productSku");
            int quantity = (Integer)payload.get("quantity");
            OrderRecord order = this.ecommerceService.placeOrder(sku, quantity);
            return ResponseEntity.ok(order);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping({"/orders"})
    public ResponseEntity<List<OrderRecord>> getOrders() {
        return ResponseEntity.ok(this.ecommerceService.getAllOrders());
    }
}
