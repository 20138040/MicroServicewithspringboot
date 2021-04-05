package com.microservice.demo.service;

import com.microservice.demo.entity.Products;
import com.microservice.demo.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;

    @Autowired
    public  ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public List<Products> allProducts(){
        return  this.productRepository.findAll();
    }

    public Products saveProduct(Products product){
        return this.productRepository.save(product);
    }

    public Products findById(Long id){
        return  this.productRepository.findById(id).orElse(new Products());
    }

    public List<Products> findByCustId(int id){
        return productRepository.findByCustId(id);
    }

}
