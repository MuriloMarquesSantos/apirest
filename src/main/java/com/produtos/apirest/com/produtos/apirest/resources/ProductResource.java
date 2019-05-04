package com.produtos.apirest.com.produtos.apirest.resources;


import com.produtos.apirest.com.produtos.apirest.models.Product;
import com.produtos.apirest.com.produtos.apirest.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ProductResource {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/product/id")
    public Product findProductById(@PathVariable(value="id") long id) {
        return productRepository.findById(id);
    }

    @PostMapping("/product")
    public Product saveProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
