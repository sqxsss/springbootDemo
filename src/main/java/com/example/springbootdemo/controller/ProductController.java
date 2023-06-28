package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Product;
import com.example.springbootdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable String id){
        return productService.getById(id);
    }

    @DeleteMapping("")
    public String deleteById(@RequestParam String id){
        return productService.deleteById(id);
    }
}
