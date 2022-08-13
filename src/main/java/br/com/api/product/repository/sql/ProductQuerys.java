package br.com.api.product.repository.sql;

public class ProductQuerys {

    public static final String FIND_BY_ID = " SELECT * FROM produtos p WHERE id = :productId ";
}
