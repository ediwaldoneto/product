package br.com.api.product.service.impl;

import br.com.api.product.exception.ProductException;
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
    public Product getProductById(Long id) throws ProductException {
        try {
            logger.info("searching by id: {}", id);
            return service.findProduct(id);
        } catch (Exception e) {
            throw new ProductException("an error has occurred: " + e.getMessage());
        }
    }

    @Override
    public void insertProduct(Product product) throws ProductException {
        try {
            service.insertProduct(product);
        } catch (Exception e) {
            throw new ProductException("an error has occurred:" + e.getMessage());
        }
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        Product product = getProductById(id);
        if (product != null) {
            try {
                service.deleteProduct(product.getId());
            } catch (Exception e) {
                throw new ProductException("an error has occurred: " + e.getMessage());
            }
        }
    }

}
