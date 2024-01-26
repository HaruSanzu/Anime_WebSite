package com.example.anime_website.repo;

import com.example.anime_website.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_Repository extends JpaRepository<User, Long> {
}
