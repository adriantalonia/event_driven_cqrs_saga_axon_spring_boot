package com.eventproject.productservice.controller;

import com.eventproject.productservice.dto.ProductRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public String createProduct(@RequestBody ProductRequest product) {
        return "HTTP POST Handler " + product.getTitle();
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
