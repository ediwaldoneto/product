package br.com.api.product.repository;

import br.com.api.product.model.Product;

import java.util.List;

public interface ProductRepository {

    public void insertProduct(Product product);

    public void deleteProduct(Long productId);

    public void updateProduct(Long productId);

    public Product findProduct(Long productId);

    public List<Product> findAll();
}
