package com.example.back_mercado.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tab_orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;

    @Column(length = 4000)
    private String items; // string describing items from frontend

    private String total;

    private LocalDateTime createdAt = LocalDateTime.now();

    public OrderEntity() {}

    public OrderEntity(String customerName, String items, String total) {
        this.customerName = customerName;
        this.items= items;
        this.total = total;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getItems() { return items; }
    public void setItems(String items) { this.items = items; }

    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
