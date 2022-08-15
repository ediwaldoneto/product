package br.com.api.product.controller;

import br.com.api.product.dto.ProductDTO;
import br.com.api.product.dto.response.Response;
import br.com.api.product.model.Product;
import br.com.api.product.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping(value = "/product")
@RestController
public class ProductController {
    @Autowired
    private ProductServiceImpl serviceProduct;

    @GetMapping("/{id}")
    public ResponseEntity<Response<Product>> findById(@PathVariable final Long id) {
        Response<Product> response = new Response<>();
        Product product = serviceProduct.getProductById(id);

        if (product == null) {
            response.addErrorMsgToResponse("Product not found:");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.setData(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Response<ProductDTO>> create(@Valid @RequestBody ProductDTO productDTO, BindingResult result) {
        Response<ProductDTO> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(objectError ->
                    response.addErrorMsgToResponse(objectError.getDefaultMessage()));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        serviceProduct.insertProduct(productDTO.convertDTOToEntity());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
