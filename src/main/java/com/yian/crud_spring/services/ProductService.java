package com.yian.crud_spring.services;

import com.yian.crud_spring.dtos.PageResponseDTO;
import com.yian.crud_spring.dtos.ProductDTO;
import com.yian.crud_spring.dtos.ProductResponseDTO;
import com.yian.crud_spring.entities.Product;

import java.util.List;

public interface ProductService {
    // CRUD OPERATIONS (Create,read,update,delete)
    ProductResponseDTO createProduct(ProductDTO productDTO);
    List<ProductResponseDTO> getAllProducts();
    ProductResponseDTO getProductById(String productId);
    ProductResponseDTO updateProduct(String productId, ProductDTO productDTO);
    void deleteProductById(String productId);

    //결과값의 형태 (Product의 형태) -> id,price,etc. createProduct -> 함수이름,()->매개변수, 수정할 대상&내용

    //pagination 전체 데이터 가져오기
    PageResponseDTO getProductsWithPagination(int pageNo, int pageSize, String sortBy, String sortDir);
}
