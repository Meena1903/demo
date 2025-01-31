package com.example.multidataset1.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.multidataset1.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
