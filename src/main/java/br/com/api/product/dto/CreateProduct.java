package br.com.api.product.dto;

import br.com.api.product.model.Product;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CreateProduct {
    @NotEmpty(message = "name cannot be empty or null.")
    @NotNull(message = "name cannot be empty or null.")
    private String nome;

    @NotNull(message = "code cannot be empty or null")
    private int codigo;

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
