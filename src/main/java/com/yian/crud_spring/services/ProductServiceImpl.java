package com.yian.crud_spring.services;


import com.yian.crud_spring.dtos.ProductDTO;
import com.yian.crud_spring.dtos.ProductResponseDTO;
import com.yian.crud_spring.entities.Product;
import com.yian.crud_spring.mappers.ProductMapper;
import com.yian.crud_spring.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    //business logic 구성하는 파일
    private final ProductRepository productRepository;

    @Override
    public ProductResponseDTO createProduct(ProductDTO productDTO) {
        return null;
    }
//전체 product data 가져오는 logic
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll(); //products table에 있는 모든 정보 가져옴;type;products
        return products.stream()
                .map(ProductMapper::mapToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProductById(String productId) {
        return null;
    }

    @Override
    public ProductResponseDTO updateProduct(String productId, ProductDTO productDTO) {
        return null;
    }

    @Override
    public void deleteProductById(String productId) {

    }
}

//entity-> repository -> service(service->service impl)-> controller(request 정의)