package br.com.api.product.service;

import br.com.api.product.dto.ProductDTO;
import br.com.api.product.model.Product;

import java.util.List;


public interface ProductService {

    public Product getProductById(Long id);

    public void insertProduct(Product product);

    public void deleteProduct(Long id);

    public List<Product> findAll();

    public void updateProduct(ProductDTO productDTO);
}
