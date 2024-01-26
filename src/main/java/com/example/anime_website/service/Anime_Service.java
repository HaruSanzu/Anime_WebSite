package com.example.anime_website.service;

import com.example.anime_website.models.Anime_Multimedia;
import com.example.anime_website.repo.Anime_Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class Anime_Service {
    private Anime_Repository anime_repository;

    @Autowired
    public Anime_Service(Anime_Repository anime_repository) {
        this.anime_repository = anime_repository;
    }

    public List<Anime_Multimedia> findAnimeByName(String name){
        return anime_repository.findAnime_MultimediaByName(name);
    }

    public List<Anime_Multimedia> getAllAnime(){
        return anime_repository.findAllAnimeNative();
    }
}
