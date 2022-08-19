package com.eventproject.productservice.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public String createProduct() {
        return "HTTP POST Handler";
    }

    @GetMapping
    public String getProduct() {
        return "HTTP GET Handler";
    }

    @PutMapping
    public String putProduct() {
        return "HTTP PUT Handler";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP Delete Handler";
    }
}
