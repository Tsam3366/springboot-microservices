package com.example.productservice.controller;

import com.example.productservice.dto.ProductRequestDto;
import com.example.productservice.dto.ProductResponseDto;
import com.example.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequestDto productRequestDto) {
        productService.createProduct(productRequestDto);
    }

@GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponseDto> getAllProduct(){
        return productService.getAllProducts();
}
}
