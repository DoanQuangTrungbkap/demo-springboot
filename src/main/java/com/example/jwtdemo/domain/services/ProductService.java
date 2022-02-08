package com.example.jwtdemo.domain.services;

import com.example.jwtdemo.app.dtos.ProductDTO;
import com.example.jwtdemo.domain.entities.Product;
import com.example.jwtdemo.domain.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
@Log4j2
public class ProductService {
    @Autowired
    private ProductRepository productRepository;


//    public ArrayList<ProductDTO> getAll() {
//        ArrayList<ProductDTO> productDTOS = new ArrayList<>();
//        for (Product item : productRepository.findAll()) {
//            productDTOS.add(ProductMapper.toProductDTO(item));
//        }
//        return productDTOS;
//    }

    public Integer create(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        productRepository.save(product);
        return product.getId();
    }

    public Boolean update(Integer id, ProductDTO dto) throws Exception {
        Product product = productRepository.findProductById(id);
        if (product == null) {
            throw new Exception();
        }
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setQuantity(dto.getQuantity());
        productRepository.save(product);
        return true;
    }

    public Product detail(Integer id) throws Exception {
        Product product = productRepository.findProductById(id);
        if (product == null) {
            throw new Exception();
        }
        return product;
    }

    public Boolean delete(Integer id) throws Exception {
        Product product = productRepository.findProductById(id);
        if (product == null) {
            throw new Exception();
        }
        productRepository.delete(product);
        return true;
    }
}
