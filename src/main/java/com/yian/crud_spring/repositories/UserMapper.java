package com.yian.crud_spring.repositories;

import com.yian.crud_spring.dtos.UserRequestDTO;
import com.yian.crud_spring.dtos.UserResponseDTO;
import com.yian.crud_spring.entities.User;

public class UserMapper {

    //DTO -> Entity
    public static User mapToUserEntity(UserRequestDTO userRequestDTO) {
        return User.builder()
                .username(userRequestDTO.getUsername())
                .email(userRequestDTO.getEmail())
                .password(userRequestDTO.getPassword())
                .build();
    }

    //Entity -> DTO
    public static UserResponseDTO mapToUserResponse(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO(); // ✅ 올바른 DTO
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setEmail(user.getEmail());
        return userResponseDTO;
    }

//        return UserResponseDTO.builder()
//                .id(user.getId())
//                .username(user.getUsername())
//                .email(user.getEmail())
//                .build();
}
