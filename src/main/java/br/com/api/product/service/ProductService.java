package br.com.api.product.service;

import br.com.api.product.model.Product;


public interface ProductService {

    public Product getProductById(Long id);
    public void insertProduct(Product product);
}
