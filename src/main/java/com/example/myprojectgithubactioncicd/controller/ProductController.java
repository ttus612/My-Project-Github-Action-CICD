package com.example.myprojectgithubactioncicd.controller;

import com.example.myprojectgithubactioncicd.models.Product;
import com.example.myprojectgithubactioncicd.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }


    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable long id){
        return productRepository.findById(id).get();
    }
}
