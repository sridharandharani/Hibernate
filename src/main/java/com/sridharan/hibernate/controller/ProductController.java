package com.sridharan.hibernate.controller;

import com.sridharan.hibernate.model.Product;
import com.sridharan.hibernate.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addproduct")
    public Product addProduct(@RequestBody Product product){
        log.info(" Inside Product Added");
        return service.saveProduct(product);
    }
    @PostMapping("/addproducts")
    public List<Product> addProducts(@RequestBody List<Product> products){
        log.info(" Inside All the Products are Saved");
        return service.saveProducts(products);
    }
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        log.info("Inside Get all Products");
        return service.getProducts();
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){
        log.info("Inside Get product with id");
        return service.getProductById(id);
    }

    @PutMapping("/updateproduct/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product){
        log.info("Inside Update the Product");
        product.setId(id);
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id){
        log.info("Inside Delete Product");
        return service.deleteProduct(id);
    }
}
