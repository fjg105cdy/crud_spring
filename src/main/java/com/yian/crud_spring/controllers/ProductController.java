package com.yian.crud_spring.controllers;

import com.yian.crud_spring.dtos.ProductDTO;
import com.yian.crud_spring.dtos.ProductResponseDTO;
import com.yian.crud_spring.entities.Product;
import com.yian.crud_spring.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    //Product를 생성하는 API
    @PostMapping("/create")
    public ResponseEntity<ProductResponseDTO> create( @RequestBody ProductDTO productDTO) {
        ProductResponseDTO savedProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
//프로덕트 테이블에 있는 데이터를 모두 가져오는 api
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);

    }

    //특정(id) 프로덕트를 가져오는 API
    @GetMapping("/{productID}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable String productID) {
        ProductResponseDTO product = productService.getProductById(productID);
        return ResponseEntity.ok(product);

    }
}
