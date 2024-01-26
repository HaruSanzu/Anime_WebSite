package com.example.anime_website.controller;

import com.example.anime_website.models.Anime_Multimedia;
import com.example.anime_website.service.Anime_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/anime")
public class Anime_Controller {
    private Anime_Service anime_service;

    @Autowired
    public Anime_Controller(Anime_Service anime_service) {
        this.anime_service = anime_service;
    }

    @GetMapping("/getAnime/search")
    public List<Anime_Multimedia> getAnimeByName(@RequestParam  String name){
         return (List<Anime_Multimedia>) anime_service.findAnimeByName(name);
    }

    @GetMapping("/getAnimeList")
    public List<Anime_Multimedia> getAllAnimes(){
        return (List<Anime_Multimedia>) anime_service.getAllAnime();
    }

}
