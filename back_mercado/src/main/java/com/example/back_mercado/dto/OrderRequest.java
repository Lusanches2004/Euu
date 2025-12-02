package com.example.back_mercado.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class OrderRequest {

    @NotBlank
    private String customerName;

    @NotBlank
    private String items;

    @NotNull
    @DecimalMin("0.0")
    private String total;

    public OrderRequest() {}

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getItems() { return items; }
    public void setItems(String items) { this.items = items; }

    public String getTotal() { return total; }
    public void setTotal(String total) { this.total = total; }
}
