package com.example.restapi.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.example.restapi.model.User;

import jakarta.annotation.PostConstruct;

@Service
public class UserService {

    private List<User> userList;
    public UserService(List<User> userList) {
        this.userList = userList;
    }

    @PostConstruct
    public void userService(){

        userList = new ArrayList<>();

        User user1 = new User(101, "asa", 21);
        User user2 = new User(102, "asb", 21);
        User user3 = new User(103, "asc", 21);
        User user4 = new User(104, "asd", 21);
      
        userList.addAll(Arrays.asList(user1,user2,user3,user4));

    }

    public User getUser(Integer id){
        return userList.stream().filter(user -> Objects.equals(user.getId(), id)).findFirst().get();
    }

}
