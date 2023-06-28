package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Product;
import com.example.springbootdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/products")
public class ProductControllerV2 {

    @Qualifier("productServiceImplV2")
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
