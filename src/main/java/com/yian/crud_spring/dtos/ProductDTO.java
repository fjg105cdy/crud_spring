package com.yian.crud_spring.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    //목적: 사용자 입력
    @NotBlank(message="Name is required")
    @Min(value=3,message="Name must be at least 3 characters")
    private String name;

    @NotBlank(message="Description is required")
    @Max(value=100,message="Description must be less than 100 char")
    private String description;

    @NotBlank(message="Price is required")
    private Long price;

    private String productImg;
}
