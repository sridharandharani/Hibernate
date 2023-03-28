package com.sridharan.hibernate.repository;

import com.sridharan.hibernate.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
