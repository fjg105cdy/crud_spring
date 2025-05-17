package com.yian.crud_spring.mappers;

import com.yian.crud_spring.dtos.ProductDTO;
import com.yian.crud_spring.dtos.ProductResponseDTO;
import com.yian.crud_spring.entities.Product;


public class ProductMapper {

    //DTO ->entity
    public static Product mapToProductEntity(ProductDTO productDTO){
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setProductImg(productDTO.getProductImg());
        return product;
        //dto -> product 형태

    }
    //Entity-> DTO
    public static ProductResponseDTO mapToProductResponseDTO(Product product){
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setId(product.getId());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setProductImg(product.getProductImg());
        return productResponseDTO;
    }
}
