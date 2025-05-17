package com.yian.crud_spring.dtos;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ProductResponseDTO {
    //결과 형태를 나타내는 모양
    private String id;
    private String name;
    private String description;
    private Long price;
    private String productImg;

}
