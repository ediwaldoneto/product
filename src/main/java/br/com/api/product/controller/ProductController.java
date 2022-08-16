package br.com.api.product.controller;

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


@RequestMapping(value = "/product")
@RestController
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
            response.addErrorMsgToResponse(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
    @PostMapping
    public ResponseEntity<Response<ProductDTO>> create(@Valid @RequestBody ProductDTO productDTO) {
        Response<ProductDTO> response = new Response<>();
        try {
            service.insertProduct(productDTO.convertDTOToEntity());
        } catch (Exception e) {
            logger.info(e.getMessage());
            response.setData(productDTO);
            response.addErrorMsgToResponse(e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
