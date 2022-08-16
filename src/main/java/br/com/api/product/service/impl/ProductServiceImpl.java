package br.com.api.product.service.impl;

import br.com.api.product.exception.ProductNotFoundException;
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
    public Product getProductById(Long id) throws ProductNotFoundException {
        try {
            return service.findProduct(id);
        } catch (Exception e) {
            logger.info(e.getMessage());
            throw new ProductNotFoundException("product not found.");
        }
    }

    @Override
    public void insertProduct(Product product) {
        service.insertProduct(product);
    }

    @Override
    public void deleteProduct(Long id) throws ProductNotFoundException {
        Product product = getProductById(id);
        if (product != null) {
            service.deleteProduct(product.getId());
        }
    }


}
