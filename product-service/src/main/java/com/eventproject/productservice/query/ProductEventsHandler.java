package com.eventproject.productservice.query;

import com.eventproject.productservice.core.events.ProductCreatedEvent;
import com.eventproject.productservice.core.model.entity.Product;
import com.eventproject.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductEventsHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product productEntity = new Product();
        BeanUtils.copyProperties(event, productEntity);
        productRepository.save(productEntity);
    }
}
