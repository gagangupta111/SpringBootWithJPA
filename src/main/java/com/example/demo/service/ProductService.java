package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Optional<Product> findProductById(Long id);

    Optional<Product> findProductByName(String name);

    List<Product> findAll();

    Product save(Product product);

    Boolean deleteAll();

    Boolean deleteByID(Long id);

    Object dataSource();

}
