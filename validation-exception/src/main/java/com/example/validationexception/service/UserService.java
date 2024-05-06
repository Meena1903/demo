package com.example.validationexception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validationexception.dto.UserRequest;
import com.example.validationexception.entity.User;
import com.example.validationexception.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User saveUser(UserRequest userRequest){
        User user = User.build(0, userRequest.getName(), userRequest.getEmailID(), userRequest.getGender());
        return repo.save(user);
    }

    public List<User> getAllUser(){
        return repo.findAll();
    }

    public User getUser(int id){
        return repo.findById(id).orElse(null);
    }
}
