package com.example.springbootdemo.service;

import com.example.springbootdemo.error.ProductNotFoundException;
import com.example.springbootdemo.model.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductServiceImpl implements ProductService{
    List<Product> productList = new ArrayList<>();

    @Override
    public Product save(Product product) {
        if(product.getProductId() == null){
            product.setProductId(UUID.randomUUID().toString());
        }
        productList.add(product);
        return product;
    }

    @Override
    public List<Product> getAll() {
        return productList;
    }

    @Override
    public Product getById(String id) {
        return productList.stream().filter(product -> product.getProductId().equals(id)).findFirst()
                .orElseThrow(()-> new ProductNotFoundException("product not found " + id));
    }

    @Override
    public String deleteById(String id) {
        Product p = productList.stream().filter(product -> product.getProductId().equals(id)).findFirst()
                .orElseThrow(()-> new RuntimeException("Generic Exception"));
        productList.remove(p);
        return "product" + id + "has been deleted";
    }


}
