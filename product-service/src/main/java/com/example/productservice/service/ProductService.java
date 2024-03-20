package com.example.productservice.service;

import com.example.productservice.dto.ProductRequestDto;
import com.example.productservice.dto.ProductResponseDto;
import com.example.productservice.model.Product;
import com.example.productservice.repo.ProductRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepo productRepo;
    public void createProduct(ProductRequestDto productRequestDto)
    {
        Product product= Product.builder().name(productRequestDto.getName()).price(productRequestDto.getPrice()).description(productRequestDto.getDescription())
                .build();
        productRepo.save(product);
        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponseDto> getAllProducts() {
        return productRepo.findAll().stream().map(e->{
            ProductResponseDto product=ProductResponseDto.builder().id(e.getId()).name(e.getName()).price(e.getPrice()).description(e.getDescription()).build();
            return product;
        }).collect(Collectors.toList());

    }
}
