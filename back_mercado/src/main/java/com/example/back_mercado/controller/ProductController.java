package com.example.back_mercado.controller;

import com.example.back_mercado.dto.ProductDto;
import com.example.back_mercado.model.Product;
import com.example.back_mercado.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins =  "http://localhost:5174/")
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDto> list(@RequestParam(value = "q", required = false) String q) {
        if (q == null || q.isBlank()) return productService.listAll();
        return productService.searchByNomeCompleto(q.trim());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Long id) {
        ProductDto dto = productService.findById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@Valid @RequestBody ProductDto dto) {
        Product product = new Product(
                dto.getNomeCompleto(),
                dto.getCidade(),
                dto.getEndereco(),
                dto.getNumero(),
                dto.getBairro(),
                dto.getComplemento(),
                dto.getFormaPagamento(),
                dto.getCep()
        );
        ProductDto saved = productService.save(product);
        return ResponseEntity.created(URI.create("/api/products/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Long id, @Valid @RequestBody ProductDto dto) {
        ProductDto updated = productService.update(id, dto);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean deleted = productService.delete(id);
        if (!deleted) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
