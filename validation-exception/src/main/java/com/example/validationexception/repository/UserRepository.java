package com.example.validationexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.validationexception.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    User findUserId(int id);
}
