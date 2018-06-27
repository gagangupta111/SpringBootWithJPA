package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    @ResponseBody
    public Product getProductById(@PathVariable("id") Long id) {
        Optional<Product> productOptional = productService.findProductById(id);

        return productOptional.get();

    }

    @GetMapping("/product/name/{name}")
    @ResponseBody
    public Product getProductByName(@PathVariable("name") String name) {

        Optional<Product> productOptional = productService.findProductByName(name);
        return productOptional.get();

    }

    @GetMapping("/product/")
    @ResponseBody
    public List<Product> getAllProducts() {

        return productService.findAll();

    }

    @PostMapping("/product/save")
    @ResponseBody
    public Product saveProduct(@RequestBody Product product) {

            return productService.save(product);

    }

    @DeleteMapping("/product/all")
    @ResponseBody
    public Boolean deleteAllProducts() {

        return productService.deleteAll();

    }

    @DeleteMapping("/product/{id}")
    @ResponseBody
    public Boolean deleteProductByID(@PathVariable("id") Long id) {

        return productService.deleteByID(id);

    }

    @GetMapping("/product/source")
    @ResponseBody
    public Object getDataSource() {

        return productService.dataSource();

    }

}
