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

    private final Logger logger = LoggerFactory.getLogger("productService");
    @Autowired
    private ProductRepositoryImpl service;

    @Override
    public Product getProductById(Long id) {
        logger.info("searching by id {}",id);
        return service.findProduct(id);
    }

    @Override
    public void insertProduct(Product product) throws ProductException {
        service.insertProduct(product);
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        Product product = getProductById(id);
        if (product != null) {
            logger.info("deleting product {}",id);
            service.deleteProduct(product.getId());
        }
    }

}
