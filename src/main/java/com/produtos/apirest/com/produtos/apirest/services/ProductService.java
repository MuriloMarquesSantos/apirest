package com.produtos.apirest.com.produtos.apirest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.produtos.apirest.com.produtos.apirest.models.Product;
import com.produtos.apirest.com.produtos.apirest.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Product> findProducts() {
        return productRepository.findAll();
    }

    public Product findById(long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Product productById) {
        productRepository.delete(productById);
    }
}
