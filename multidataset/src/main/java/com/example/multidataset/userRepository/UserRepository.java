package com.example.multidataset.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.multidataset.modelUesr.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
