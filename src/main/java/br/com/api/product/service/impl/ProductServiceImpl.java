package br.com.api.product.service.impl;

import br.com.api.product.model.Product;
import br.com.api.product.repository.impl.ProductRepositoryImpl;
import br.com.api.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepositoryImpl service;

    @Override
    public Product getProductById(int id) {
        return service.findProduct(id);
    }
}
