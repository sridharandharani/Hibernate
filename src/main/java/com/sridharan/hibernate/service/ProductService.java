package com.sridharan.hibernate.service;

import com.sridharan.hibernate.model.Product;
import com.sridharan.hibernate.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product){
        log.info("Product with Id: {} is saved",product.getId());
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products){
        log.info("Products is saved");
        return repository.saveAll(products);
    }

    public List<Product> getProducts(){
        log.info("Getting All Products");
        return repository.findAll();
    }

    public Product getProductById(int id){
        log.info("Getting Product with Id: {}", id);
        return repository.findById(id).get();
    }

    public Product updateProduct(Product product){
        Product OldProduct = repository.findById(product.getId()).get();
        OldProduct.setName(product.getName());
        OldProduct.setQuantity(product.getQuantity());
        OldProduct.setPrice(product.getPrice());
        log.info("Updating Product with Id: {}",product.getId());
        return repository.save(OldProduct);
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        log.info("Deleting Product with Id: {}",id);
        return "Product Removed with id: "+id;
    }
}
