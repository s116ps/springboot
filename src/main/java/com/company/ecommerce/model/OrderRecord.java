package com.company.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class OrderRecord {
    @Id
    private String orderId;
    private String productSku;
    private int quantity;
    private double totalAmount;
    private String status;

    public OrderRecord() {
    }

    public OrderRecord(String orderId, String productSku, int quantity, double totalAmount, String status) {
        this.orderId = orderId;
        this.productSku = productSku;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductSku() {
        return this.productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }
}

