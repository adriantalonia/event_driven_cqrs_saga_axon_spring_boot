package com.eventproject.productservice.query;

import com.eventproject.productservice.core.model.entity.Product;
import com.eventproject.productservice.query.rest.ProductRestModel;
import com.eventproject.productservice.repository.ProductRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {

    private final ProductRepository productRepository;

    public ProductQueryHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> findProducts(FindProductsQuery query) {
        List<ProductRestModel> productRestModels = new ArrayList<>();
        List<Product> storedProducts = productRepository.findAll();

        for(Product productEntity: storedProducts) {
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            productRestModels.add(productRestModel);
        }
        return productRestModels;
    }
}
