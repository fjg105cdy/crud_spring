package com.yian.crud_spring.dtos;


import lombok.*;

import java.time.LocalDateTime;

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
    private String price;
    private String productImg;
    private LocalDateTime createdAt;

}
