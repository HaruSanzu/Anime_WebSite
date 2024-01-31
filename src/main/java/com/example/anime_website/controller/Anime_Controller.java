package com.example.anime_website.controller;

import com.example.anime_website.models.Anime_Multimedia;
import com.example.anime_website.service.Anime_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/anime")
public class Anime_Controller {
    private Anime_Service anime_service;

    @Autowired
    public Anime_Controller(Anime_Service anime_service) {
        this.anime_service = anime_service;
    }

    @GetMapping("/getAnime")
    public List<Anime_Multimedia> getAnimeByName(@RequestParam  String name){
         return (List<Anime_Multimedia>) anime_service.findAnimeByName(name);
    }

    @GetMapping("/getAnimeList")
    public List<Anime_Multimedia> getAllAnimes(){
        return (List<Anime_Multimedia>) anime_service.getAllAnime();
    }

    @GetMapping("/getAnimeType")
    public List<Anime_Multimedia> getAnimeByType(@RequestParam String type){
        return anime_service.findAnimeByType(type);
    }

    @GetMapping("/getAnimeGenres")
    public List<Anime_Multimedia> getAnimeByGenres(@RequestParam String genres){
        return anime_service.findAnimeByGenres(genres);
    }

    @PostMapping("/addAnime")
    public Integer addAnime(@RequestBody Map<String, Object> animeRequest){
        Integer id = (Integer) animeRequest.get("id");
        String name = (String) animeRequest.get("name");
        String type = (String) animeRequest.get("type");
        String premiered = (String) animeRequest.get("premiered");
        String duration = (String) animeRequest.get("duration");
        String studios = (String) animeRequest.get("studios");
        Double score = (Double) animeRequest.get("score");
        List<String> genres = (List<String>) animeRequest.get("genres");
        return anime_service.AddAnime(id,name,type,premiered,duration,studios,score, String.valueOf(genres));
    }

    @PutMapping("/{id}/UpdateAnimeById")
    public Integer updateAnimeById(@PathVariable Integer id,@RequestBody Map<String, Object> animeRequest ){
        String name = (String) animeRequest.get("name");
        String type = (String) animeRequest.get("type");
        String premiered = (String) animeRequest.get("premiered");
        String duration = (String) animeRequest.get("duration");
        String studios = (String) animeRequest.get("studios");
        Double score = (Double) animeRequest.get("score");
        List<String> genres = (List<String>) animeRequest.get("genres");
        return anime_service.updateAnimeById(id,name,type,premiered,duration,studios,score, String.valueOf(genres));
    }

    @DeleteMapping("/deleteAnimeById/{id}")
    public Anime_Multimedia deleteAnimeById(@PathVariable("id") Integer id){
        return anime_service.deleteAnimeById(id);
    }

}
