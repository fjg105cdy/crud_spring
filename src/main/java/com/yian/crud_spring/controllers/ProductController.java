package com.yian.crud_spring.controllers;

import com.yian.crud_spring.dtos.PageResponseDTO;
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
    public ResponseEntity<ProductResponseDTO> create(@RequestBody ProductDTO productDTO) {
        ProductResponseDTO savedProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    //프로덕트 테이블에 있는 데이터를 모두 가져오는 api
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts() {
        List<ProductResponseDTO> products = productService.getAllProducts();
        return ResponseEntity.ok(products);

    }

    @GetMapping ("/pagination")
    public ResponseEntity<PageResponseDTO> getProductsWithPagination(
            @RequestParam(defaultValue = "1") int pageNo,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue="name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDir,
            @RequestParam(required = false) String searchKeyword

    ){
        PageResponseDTO pageResponseDTO=productService.getProductsWithPagination(pageNo, pageSize, sortBy, sortDir,searchKeyword);
        return ResponseEntity.ok(pageResponseDTO);
    }


    //특정(id) 프로덕트를 가져오는 API
    @GetMapping("/{productID}")
    public ResponseEntity<ProductResponseDTO> getProductById(@PathVariable String productID) {
        ProductResponseDTO product = productService.getProductById(productID);
        return ResponseEntity.ok(product);

    }

    //특정 (id) 프로덕트 삭제하는 API
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable String productId) {
        productService.deleteProductById(productId);
        return ResponseEntity.ok("deleted product");
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDTO> updateProduct(
            @PathVariable String productId,//수정할 대상
            @RequestBody ProductDTO productDTO//수정할 내용
    ){
        ProductResponseDTO updatedProduct = productService.updateProduct(productId, productDTO);
        return ResponseEntity.ok(updatedProduct);

    }
}
