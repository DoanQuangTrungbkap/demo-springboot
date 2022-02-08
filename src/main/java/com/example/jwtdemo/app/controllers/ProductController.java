package com.example.jwtdemo.app.controllers;

import com.example.jwtdemo.app.dtos.ProductDTO;
import com.example.jwtdemo.domain.entities.Product;
import com.example.jwtdemo.domain.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public Integer createProduc(@RequestBody ProductDTO dto) {
        return productService.create(dto);
    }

    @GetMapping(path = "{id}")
    public Product detailProduct(@PathVariable("id") Integer id) throws Exception {
        return productService.detail(id);
    }

    @PutMapping(path = "{id}")
    public Boolean updateProduct(@PathVariable("id") Integer id, @RequestBody ProductDTO dto) throws Exception {
        return productService.update(id, dto);
    }

    @DeleteMapping(path = "{id}")
    public Boolean deleteProduct(@PathVariable("id") Integer id) throws Exception {
        return productService.delete(id);
    }
}
