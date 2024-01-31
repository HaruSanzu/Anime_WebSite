package com.example.anime_website.controller;

import com.example.anime_website.models.User;
import com.example.anime_website.service.User_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class User_Controller {

    User_Service user_service;
    @Autowired
    public User_Controller(User_Service user_service) {
        this.user_service = user_service;
    }



    @GetMapping("/getAllUsers")
    List<User> getAllUsers(){
        return user_service.findAllUsers();
    }

    @GetMapping("/getUserByUsername")
    List<User> findUserByUsername(String username){
        return user_service.findUsersByUsername(username);
    }

    @GetMapping("/getUserByEmail")
    List<User> findUserByEmail(String email){
        return user_service.findUsersByEmail(email);
    }
}
