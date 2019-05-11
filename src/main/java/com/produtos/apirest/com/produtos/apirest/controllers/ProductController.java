package com.produtos.apirest.com.produtos.apirest.controllers;


import com.produtos.apirest.com.produtos.apirest.models.Product;
import com.produtos.apirest.com.produtos.apirest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/{id}")
    public Product findProductById(@PathVariable long id) {
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable long id) {
        productRepository.delete(findProductById(id));

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
