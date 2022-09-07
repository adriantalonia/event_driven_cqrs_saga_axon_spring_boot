package com.eventproject.productservice.command.rest;

import com.eventproject.productservice.command.CreateProductCommand;
import com.eventproject.productservice.core.model.dto.ProductRequest;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;


    @PostMapping
    public String createProduct(@RequestBody ProductRequest product) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .title(product.getTitle())
                .productId(UUID.randomUUID().toString()).build();

        String returnValue;

        try {
            returnValue = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception ex) {
            returnValue = ex.getLocalizedMessage();
        }

        return "HTTP POST Handler " + returnValue;
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
