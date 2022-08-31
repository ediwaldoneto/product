package br.com.api.product.controller;

import br.com.api.product.dto.CreateProduct;
import br.com.api.product.dto.ProductDTO;
import br.com.api.product.dto.response.Response;
import br.com.api.product.model.Product;
import br.com.api.product.service.impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RequestMapping(value = "/product")
@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger("logger");

    @Autowired
    private ProductServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<Response<ProductDTO>> findById(@PathVariable final Long id) {
        Response<ProductDTO> response = new Response<>();
        try {
            Product product = service.getProductById(id);
            ProductDTO productDTO = product.convertEntityToDTO();
            response.setData(productDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.addErrorMsgToResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Response<CreateProduct>> create(@Valid @RequestBody CreateProduct product) {
        Response<CreateProduct> response = new Response<>();
        try {
            service.insertProduct(product.convertDTOToEntity());
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.setData(product);
            response.addErrorMsgToResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response<ProductDTO>> delete(@PathVariable final Long id) {
        Response<ProductDTO> response = new Response<>();
        try {
            service.deleteProduct(id);
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.addErrorMsgToResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Response<List<ProductDTO>>> findAllProduct() {
        Response<List<ProductDTO>> response = new Response<>();
        try {
            List<Product> product = service.findAll();
            List<ProductDTO> dtoList = new ArrayList<>();
            product.forEach(product1 -> dtoList.add(product1.convertEntityToDTO()));
            response.setData(dtoList);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.addErrorMsgToResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping
    public ResponseEntity<Response<ProductDTO>> update(@RequestBody ProductDTO productDTO) {
        Response<ProductDTO> response = new Response<>();
        try {
            service.updateProduct(productDTO);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.addErrorMsgToResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
