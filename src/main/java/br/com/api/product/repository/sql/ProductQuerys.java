package br.com.api.product.repository.sql;

public class ProductQuerys {

    public static final String FIND_BY_ID = " SELECT * FROM produtos p WHERE id = :productId ";
    public static final String INSERT_PRODUCT = " INSERT INTO produtos (nome,codigo) VALUES (:nome, :codigo) ";
}
