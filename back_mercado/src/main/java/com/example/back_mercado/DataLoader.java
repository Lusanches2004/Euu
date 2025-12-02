package com.example.back_mercado;

import com.example.back_mercado.model.Product;
import com.example.back_mercado.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(ProductRepository productRepository) {
        return args -> {
            if (productRepository.count() == 0) {
                productRepository.save(new Product("Arroz 5kg", "Cidade X", "Rua A", "10", "Bairro Y", "Sem complemento", "Dinheiro", "12345-678"));
                productRepository.save(new Product("Feijão 1kg", "Cidade X", "Rua B", "20", "Bairro Y", "Sem complemento", "Cartão", "12345-679"));
                productRepository.save(new Product("Óleo 900ml", "Cidade X", "Rua C", "30", "Bairro Y", "Sem complemento", "Pix", "12345-680"));
                productRepository.save(new Product("Macarrão 500g", "Cidade X", "Rua D", "40", "Bairro Y", "Sem complemento", "Dinheiro", "12345-681"));
                productRepository.save(new Product("Açúcar 1kg", "Cidade X", "Rua E", "50", "Bairro Y", "Sem complemento", "Cartão", "12345-682"));
                productRepository.save(new Product("Café 1kg", "Cidade X", "Rua F", "60", "Bairro Y", "Sem complemento", "Pix", "12345-683"));
                productRepository.save(new Product("Leite integral 1L", "Cidade X", "Rua G", "70", "Bairro Y", "Sem complemento", "Dinheiro", "12345-684"));
                productRepository.save(new Product("Caixa de bombom", "Cidade X", "Rua H", "80", "Bairro Y", "Sem complemento", "Cartão", "12345-685"));
            }
        };
    }
}
