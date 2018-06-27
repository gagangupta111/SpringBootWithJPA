package com.example.demo.service.impl;

import com.example.demo.dao.ProductRepository;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackOn = RuntimeException.class)
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    DataSource dataSource;

    public ProductServiceImpl(ProductRepository productRepository, DataSource dataSource) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        Product product = new Product();
        productRepository.save(product);
        return productRepository.findById(id);
    }

    @Override
    public Optional<Product> findProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Boolean deleteAll() {
         productRepository.deleteAll();
         return true;
    }

    @Override
    public Boolean deleteByID(Long id) {
         productRepository.deleteById(id);
         return true;
    }

    @Override
    public Object dataSource() {
        return dataSource;
    }

}
