package com.yian.crud_spring.entities;

import com.yian.crud_spring.common.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name="USERS")
public class User extends AbstractEntity {
    //Id,username,password,email

    @Column(name="USERNAME",nullable=false)
    private String username;

    @Column(name="EMAIL",nullable=false)
    private String email;

    @Column(name="PASSWORD",nullable=false)
    private String password;
}
