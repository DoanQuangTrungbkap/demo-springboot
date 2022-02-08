package com.example.jwtdemo.domain.services;

import com.example.jwtdemo.app.dtos.ProductDTO;
import com.example.jwtdemo.domain.entities.Product;
import com.example.jwtdemo.domain.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductMapper {
    @Autowired
    private ProductRepository productRepository;

    public static ProductDTO toProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(product.getName());
        product.setQuantity(product.getQuantity());
        product.setPrice(product.getPrice());
        return productDTO;
    }
}
