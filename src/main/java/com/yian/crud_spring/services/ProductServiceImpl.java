package com.yian.crud_spring.services;


import com.yian.crud_spring.dtos.PageResponseDTO;
import com.yian.crud_spring.dtos.ProductDTO;
import com.yian.crud_spring.dtos.ProductResponseDTO;
import com.yian.crud_spring.entities.Product;
import com.yian.crud_spring.exceptions.ResourceNotfoundException;
import com.yian.crud_spring.mappers.ProductMapper;
import com.yian.crud_spring.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    //기존의 상품이름과 같은 데이터 있는지 확인
        if (productRepository.existsByName(productDTO.getName())) {
            throw new RuntimeException("Product with name"+productDTO.getName()+"already exists");

        }
        // Convert DTO to Entity
        Product product = ProductMapper.mapToProductEntity(productDTO);
        //save to products
        Product savedProduct=productRepository.save(product);

        // convert Entity to ResponseDTO
        return ProductMapper.mapToProductResponseDTO(savedProduct);
    }
//전체 product data 가져오는 logics
    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll(); //products table에 있는 모든 정보 가져옴;type;products
        return products.stream()
                .map(ProductMapper::mapToProductResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponseDTO getProductById(String productId) {

       Product product = productRepository.findById(productId)
               .orElseThrow(()-> new ResourceNotfoundException("product","id",productId));
       return ProductMapper.mapToProductResponseDTO(product);

    }

    @Override
    public ProductResponseDTO updateProduct(String productId, ProductDTO productDTO) {
        //대상자 찾기
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotfoundException("product","id",productId));

        //업데이트를 했는데 이름 같은지 확인
        if (!product.getName().equals(productDTO.getName()) && productRepository.existsByName(productDTO.getName())) {
            throw new RuntimeException("Product with name"+productDTO.getName()+"already exists");
        }


        //update product details
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setProductImg(productDTO.getProductImg());


        // save product
        Product updatedProduct = productRepository.save(product);
        return ProductMapper.mapToProductResponseDTO(updatedProduct);
    }




    @Override
    public void deleteProductById(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotfoundException("product","id",productId));
        productRepository.delete(product);
    }

    @Override
    public PageResponseDTO getProductsWithPagination(
            int pageNo,
            int pageSize,
            String sortBy,
            String sortDir,
            String searchKeyword
    ) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())
                ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);

        //Page<Product> products = productRepository.findAll(pageable);

        Page<Product> products;
        //검색어가 있을때와 없을때 분기 처리

        if (searchKeyword == null||searchKeyword.trim().isEmpty()){
            products=productRepository.findAll(pageable);
        } else{
            //검색어가 입력되어 있다면
            products=productRepository.findByNameContainingIgnoreCase(searchKeyword, pageable);

        }

        List<ProductResponseDTO> productResponseDTOS = products
                .getContent()
                .stream()
                .map(ProductMapper::mapToProductResponseDTO)
                .collect(Collectors.toList());

        return PageResponseDTO.builder()
                .body(productResponseDTOS)
                .totalElements(products.getTotalElements())
                .totalPages(products.getTotalPages())
                .hasNextPage(products.hasNext())
                .hasPreviousPage(products.hasPrevious())
                .pageNo(products.getNumber())
                .pageSize(products.getSize())
                .build();
    }


}

//entity-> repository -> service(service->service impl)-> controller(request 정의)