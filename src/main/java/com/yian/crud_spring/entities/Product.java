package com.yian.crud_spring.entities;

import com.yian.crud_spring.common.AbstractEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
@Table(name="PRODUCTS")
public class Product extends AbstractEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String id;
    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    @Column(name = "PRICE", nullable = false)
    private String price;

    @Column(name = "PRODUCTIMG")
    private String productImg;

}
