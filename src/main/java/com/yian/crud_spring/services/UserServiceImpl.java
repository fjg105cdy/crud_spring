package com.yian.crud_spring.services;

import com.yian.crud_spring.dtos.UserRequestDTO;
import com.yian.crud_spring.dtos.UserResponseDTO;
import com.yian.crud_spring.entities.User;
import com.yian.crud_spring.repositories.UserMapper;
import com.yian.crud_spring.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j

public class UserServiceImpl implements UserService {
    //user repository 설정

    private final UserRepository userRepository;


    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new RuntimeException("Username with email"+userRequestDTO.getEmail()+" already exists");

        }
        User user = UserMapper.mapToUserEntity(userRequestDTO);
        User savedUser = userRepository.save(user);

        return UserMapper.mapToUserResponse(savedUser);


    }



    @Override
    public List<UserResponseDTO> findAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(UserMapper::mapToUserResponse)
                .collect(Collectors.toList());

    }

    @Override
    public UserResponseDTO findUserById(String userId) {
        return userRepository.findById(userId)
                .map(UserMapper::mapToUserResponse)
                .orElseThrow(() -> new RuntimeException("<User not found>"));

    }
}
