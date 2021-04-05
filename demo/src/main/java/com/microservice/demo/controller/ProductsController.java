package com.microservice.demo.controller;


import com.microservice.demo.entity.Products;
import com.microservice.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public Products saveProduct(@RequestBody Products product){
        return this.productService.saveProduct(product);
    }

    @GetMapping("/all")
    public List<Products> findAllProducts(){
        return this.productService.allProducts();
    }

    @GetMapping("/find/{id}")
    public Products getProductById(@PathVariable("id") Long id){
        return  productService.findById(id);
    }


    @GetMapping("/custId/{id}")
    public List<Products> findByCusId(@PathVariable("id") int id){
        return productService.findByCustId(id);
    }
}
