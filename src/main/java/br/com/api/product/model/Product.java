package br.com.api.product.model;

import br.com.api.product.dto.ProductDTO;
import org.modelmapper.ModelMapper;

public class Product {

    private Long id;
    private String nome;
    private int codigo;

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ProductDTO convertEntityToDTO() {
        return new ModelMapper().map(this, ProductDTO.class);
    }
}
