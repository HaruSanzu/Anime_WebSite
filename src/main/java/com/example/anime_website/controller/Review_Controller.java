package com.example.anime_website.controller;

import com.example.anime_website.models.Reviews;
import com.example.anime_website.service.Review_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/review")
public class Review_Controller {
    private Review_Service review_service;

    @Autowired

    public Review_Controller(Review_Service review_service) {
        this.review_service = review_service;
    }


    @PostMapping("/addReview")
    public Integer addReview(@RequestBody Map<String, Object> reviewRequest){
        Integer id = (Integer) reviewRequest.get("id");
        String review = (String) reviewRequest.get("review");
        String anime_name = (String) reviewRequest.get("anime_name");
        String username = (String) reviewRequest.get("username");
        return review_service.addReview(id,review,anime_name,username);
    }

    @GetMapping("/findAllReviews")
    public List<Reviews> findAllReviews(){
        return review_service.findAllReviews();
    }

    @GetMapping("/findReviewByAnime_name")
    public List<Reviews> findReviewByAnime_Name(@RequestParam String anime_name){
        return review_service.findReviewsByAnime_Name(anime_name);
    }


}
