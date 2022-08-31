package br.com.api.product.dto;

import br.com.api.product.model.Product;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateProduct {
    @NotEmpty(message = "name cannot be empty or null.")
    @NotNull(message = "name cannot be empty or null.")
    private String nome;

    @NotEmpty(message = "marca cannot be empty or null.")
    @NotNull(message = ",marca cannot be empty or null.")
    private String marca;

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

    public Product convertDTOToEntity() {
        return new ModelMapper().map(this, Product.class);
    }
}
