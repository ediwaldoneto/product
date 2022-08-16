package br.com.api.product.service.impl;

import br.com.api.product.model.Product;
import br.com.api.product.repository.impl.ProductRepositoryImpl;
import br.com.api.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger("logger");
    @Autowired
    private ProductRepositoryImpl service;

    @Override
    public Product getProductById(Long id) {
        return service.findProduct(id);
    }

    @Override
    public void insertProduct(Product product) {
        service.insertProduct(product);
    }


}
