package com.company.ecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InventoryItem {
    @Id
    private String productSku;
    private String productName;
    private int stockQuantity;
    private double price;

    public InventoryItem() {
    }

    public InventoryItem(String productSku, String productName, int stockQuantity, double price) {
        this.productSku = productSku;
        this.productName = productName;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    public String getProductSku() {
        return this.productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStockQuantity() {
        return this.stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

