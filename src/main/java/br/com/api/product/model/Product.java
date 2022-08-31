package br.com.api.product.model;

import br.com.api.product.dto.ProductDTO;
import org.modelmapper.ModelMapper;

public class Product {

    private Long id;
    private String nome;
    private String marca;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public ProductDTO convertEntityToDTO() {
        return new ModelMapper().map(this, ProductDTO.class);
    }
}
