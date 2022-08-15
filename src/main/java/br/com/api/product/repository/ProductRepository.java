package br.com.api.product.repository;

import br.com.api.product.model.Product;

public interface ProductRepository {

    public void insertProduct(Product product);
    public void deleteProduct(Long productId);
    public void updateProduct(Long productId);
    public Product findProduct(Long productId);
}
