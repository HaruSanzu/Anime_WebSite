package com.example.anime_website.service;

import com.example.anime_website.models.User;
import com.example.anime_website.repo.User_Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class User_Service {
    private User_Repository user_repository;
    @Autowired
    public User_Service(User_Repository user_repository) {
        this.user_repository = user_repository;
    }

    public List<User> findAllUsers(){
       return user_repository.findAllUsers();
    }

    public List<User> findUsersByUsername(String username){
        return user_repository.findUserByUsername(username);
    }

    public List<User> findUsersByEmail(String email){
        return user_repository.findUserByEmail(email);
    }
}
