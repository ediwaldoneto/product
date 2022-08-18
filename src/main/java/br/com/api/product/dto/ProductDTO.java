package br.com.api.product.dto;

import br.com.api.product.model.Product;
import org.modelmapper.ModelMapper;

public class ProductDTO {

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

    public Product convertDTOToEntity() {
        return new ModelMapper().map(this, Product.class);
    }
}
