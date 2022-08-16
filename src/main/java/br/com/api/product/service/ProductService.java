package br.com.api.product.service;

import br.com.api.product.exception.ProductException;
import br.com.api.product.model.Product;


public interface ProductService {

    public Product getProductById(Long id) throws ProductException;
    public void insertProduct(Product product) throws ProductException;
    public void deleteProduct(Long id) throws Exception;
}
