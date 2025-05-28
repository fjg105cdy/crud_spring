package com.yian.crud_spring.dtos;

//회원등록할때 입력해야하는 데이터

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDTO {
    @NotBlank(message="Username is required")
    private String username;

    @NotBlank(message="Email is required")
    @Email(message="Email is invalid)")
    private String email;

    @NotBlank(message="Password is required")
    @Size(min=8,max=16,message="Password is required")
    private String password;
}
