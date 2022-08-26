package com.eventproject.productservice.repository;

import com.eventproject.productservice.core.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findByProductId(String productId);
    Optional<Product> findByProductIdOrTitle(String productId, String title);
}
