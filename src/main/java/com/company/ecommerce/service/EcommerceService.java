package com.company.ecommerce.service;

import com.company.ecommerce.model.InventoryItem;
import com.company.ecommerce.model.OrderRecord;
import com.company.ecommerce.repository.InventoryRepository;
import com.company.ecommerce.repository.OrderRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EcommerceService {
    private final InventoryRepository inventoryRepository;
    private final OrderRepository orderRepository;

    @Autowired
    public EcommerceService(InventoryRepository inventoryRepository, OrderRepository orderRepository) {
        this.inventoryRepository = inventoryRepository;
        this.orderRepository = orderRepository;
    }

    public InventoryItem addOrUpdateInventory(InventoryItem item) {
        return (InventoryItem)this.inventoryRepository.save(item);
    }

    public List<InventoryItem> getAllInventory() {
        return this.inventoryRepository.findAll();
    }

    @Transactional
    public OrderRecord placeOrder(String productSku, int quantity) {
        InventoryItem item = (InventoryItem)this.inventoryRepository.findById(productSku).orElseThrow(() -> new IllegalArgumentException("Product SKU not found in inventory"));
        if (item.getStockQuantity() < quantity) {
            throw new IllegalStateException("Insufficient stock available for this order");
        } else {
            item.setStockQuantity(item.getStockQuantity() - quantity);
            this.inventoryRepository.save(item);
            double totalAmount = item.getPrice() * (double)quantity;
            String var10000 = UUID.randomUUID().toString();
            String orderid = "ORD-" + var10000.substring(0, 8).toUpperCase();
            OrderRecord order = new OrderRecord(orderid, productSku, quantity, totalAmount, "PLACED");
            return (OrderRecord)this.orderRepository.save(order);
        }
    }

    public List<OrderRecord> getAllOrders() {
        return this.orderRepository.findAll();
    }
}

