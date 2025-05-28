package com.yian.crud_spring.repositories;

import com.yian.crud_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
   boolean existsByEmail(String email);
   Optional<User> findByEmail(String email);
}
