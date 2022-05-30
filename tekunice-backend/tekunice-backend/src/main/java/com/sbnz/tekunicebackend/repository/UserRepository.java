package com.sbnz.tekunicebackend.repository;

import java.util.Optional;

import com.sbnz.tekunicebackend.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findById(long id);

  Optional<User> findByUsername(String username);
}
