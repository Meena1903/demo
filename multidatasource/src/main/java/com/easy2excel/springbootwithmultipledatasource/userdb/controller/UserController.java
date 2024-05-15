package com.easy2excel.springbootwithmultipledatasource.userdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.easy2excel.springbootwithmultipledatasource.userdb.entity.User;
import com.easy2excel.springbootwithmultipledatasource.userdb.repository.UserRepository;

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping("api/v2/user")
    public User saveUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("api/v2/users")
    public List<User> getUserList(){
        return userRepository.findAll();

    }

}
