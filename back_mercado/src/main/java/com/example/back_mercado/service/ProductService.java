package com.example.back_mercado.service;

import com.example.back_mercado.dto.ProductDto;
import com.example.back_mercado.model.Product;
import com.example.back_mercado.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> listAll() {
        return productRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<ProductDto> searchByNomeCompleto(String q) {
        return productRepository.findByNomeCompletoContainingIgnoreCase(q)
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id)
                .map(this::mapToDto)
                .orElse(null);
    }

    public ProductDto save(Product product) {
        Product saved = productRepository.save(product);
        return mapToDto(saved);
    }

    public ProductDto update(Long id, ProductDto dto) {
        return productRepository.findById(id)
                .map(existing -> {
                    existing.setNomeCompleto(dto.getNomeCompleto());
                    existing.setCidade(dto.getCidade());
                    existing.setEndereco(dto.getEndereco());
                    existing.setNumero(dto.getNumero());
                    existing.setBairro(dto.getBairro());
                    existing.setComplemento(dto.getComplemento());
                    existing.setFormaPagamento(dto.getFormaPagamento());
                    existing.setCep(dto.getCep());
                    Product saved = productRepository.save(existing);
                    return mapToDto(saved);
                })
                .orElse(null);
    }

    public boolean delete(Long id) {
        if (!productRepository.existsById(id)) return false;
        productRepository.deleteById(id);
        return true;
    }

    private ProductDto mapToDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getNomeCompleto(),
                product.getCidade(),
                product.getEndereco(),
                product.getNumero(),
                product.getBairro(),
                product.getComplemento(),
                product.getFormaPagamento(),
                product.getCep()
        );
    }
}
