package com.yian.crud_spring.repositories;

import com.yian.crud_spring.entities.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
    boolean existsByName(String name);
    Product findByName(String name);
}

