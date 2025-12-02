package com.example.back_mercado.controller;

import com.example.back_mercado.dto.OrderRequest;
import com.example.back_mercado.model.OrderEntity;
import com.example.back_mercado.repository.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

// Permite requisições de localhost:5173 (React/Vite)
// Ajuste a porta caso seja diferente no seu frontend
@CrossOrigin(origins = "http://localhost:5174/")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @PostMapping
    public ResponseEntity<OrderEntity> create(@Valid @RequestBody OrderRequest orderRequest) {
        OrderEntity order = new OrderEntity();
        order.setCustomerName(orderRequest.getCustomerName());
        order.setItems(orderRequest.getItems());
        order.setTotal(orderRequest.getTotal());

        OrderEntity saved = orderRepository.save(order);
        return ResponseEntity.created(URI.create("/api/orders/" + saved.getId())).body(saved);
    }

    @GetMapping
    public ResponseEntity<List<OrderEntity>> getAll() {
        return ResponseEntity.ok(orderRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderEntity> getById(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
