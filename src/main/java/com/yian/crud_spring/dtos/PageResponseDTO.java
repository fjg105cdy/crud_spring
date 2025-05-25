package com.yian.crud_spring.dtos;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDTO {
    private List<ProductResponseDTO> body;
    private long totalElements;
    private int totalPages;
    private Boolean hasPreviousPage;
    private Boolean hasNextPage;
    private int pageNo;
    private int pageSize;

}
