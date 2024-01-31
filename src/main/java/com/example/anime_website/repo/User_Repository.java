package com.example.anime_website.repo;

import com.example.anime_website.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_Repository extends JpaRepository<User, Long> {


    @Query(value = "SELECT * from \"user\" ", nativeQuery = true)
    List<User> findAllUsers();

    @Query(value = "SELECT * from \"user\" where username like %?% ", nativeQuery = true )
    List<User> findUserByUsername(String username);

    @Query(value = "SELECT * from \"user\" where email like %?% ", nativeQuery = true )
    List<User> findUserByEmail(String email);

}
