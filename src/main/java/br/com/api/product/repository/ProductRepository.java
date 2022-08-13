package br.com.api.product.repository;

import br.com.api.product.model.Product;

public interface ProductRepository {

    public void insertProduct(Product product);
    public void deleteProduct(int productId);
    public void updateProduct(int productId);
    public Product findProduct(int productId);
}
