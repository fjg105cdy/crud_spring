package com.yian.crud_spring.services;

import com.yian.crud_spring.dtos.UserRequestDTO;
import com.yian.crud_spring.dtos.UserResponseDTO;
import com.yian.crud_spring.entities.User;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    List<UserResponseDTO> findAllUsers();
    UserResponseDTO findUserById(String userId);
}
