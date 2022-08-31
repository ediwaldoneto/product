package br.com.api.product.repository.sql;

public class ProductQuerys {

    public static final String FIND_BY_ID = " SELECT * FROM produtos p WHERE id = :productId ";
    public static final String INSERT_PRODUCT = " INSERT INTO produtos (nome,marca) VALUES (:nome, :marca) ";
    public static final String DELETE_PRODUCT = " DELETE FROM produtos WHERE id = :productId ";
    public static final String UPDATE_PRODUCT = "UPDATE produtos SET nome = :nome, marca = :marca WHERE id = :contractId";
    public static final String FIND_ALL_PRODUCT = "SELECT * FROM produtos";

}
