package com.dominos.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dominos.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmail(String email);
}
