package br.com.api.product.service;

import br.com.api.product.exception.ProductNotFoundException;
import br.com.api.product.model.Product;


public interface ProductService {

    public Product getProductById(Long id) throws ProductNotFoundException;
    public void insertProduct(Product product);
    public void deleteProduct(Long id) throws ProductNotFoundException;
}
