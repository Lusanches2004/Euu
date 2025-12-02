package com.example.back_mercado.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tab_entrega") // tabela para dados de entrega
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)             
    private String endereco; 

    @Column(nullable = false)          
    private String numero;

    @Column(nullable = false)             
    private String bairro;

    @Column(nullable = false)             
    private String complemento;

    @Column(nullable = false)        
    private String formaPagamento;  

    @Column(nullable = false)
    private String cep;   

    // Construtor vazio
    public Product() {}

    // Construtor completo (opcional, útil para inicialização)
    public Product(String nomeCompleto, String cidade, String endereco, String numero,
                   String bairro, String complemento, String formaPagamento, String cep) {
        this.nomeCompleto = nomeCompleto;
        this.cidade = cidade;
        this.endereco = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.complemento = complemento;
        this.formaPagamento = formaPagamento;
        this.cep = cep;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeCompleto() { return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) { this.nomeCompleto = nomeCompleto; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getComplemento() { return complemento; }
    public void setComplemento(String complemento) { this.complemento = complemento; }

    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }
}
