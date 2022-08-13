package br.com.api.product.controller;

import br.com.api.product.model.Product;
import br.com.api.product.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping(value = "/product")
@RestController
public class ProductController {
    @Autowired
    private ProductServiceImpl serviceProduct;

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable final int id){
    return new ResponseEntity<>(serviceProduct.getProductById(id), HttpStatus.OK);
    }
}
