package com.example.springbootdemo.service;

import com.example.springbootdemo.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    List<Product> getAll();

    Product getById(String id);

    String deleteById(String id);
}
