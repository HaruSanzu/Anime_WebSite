package com.example.anime_website.service;

import com.example.anime_website.models.Reviews;
import com.example.anime_website.repo.Review_Repository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class Review_Service {
   private Review_Repository review_repository;

   @Autowired

    public Review_Service(Review_Repository review_repository) {
        this.review_repository = review_repository;
    }

    public Integer addReview(Integer id,String review,String anime_name,String username){
       return review_repository.addReview(id, review, anime_name, username);
    }

    public List<Reviews> findAllReviews(){
       return review_repository.findAllReviews();
    }

    public List<Reviews> findReviewsByAnime_Name(String anime_name){
       return review_repository.findReviewsByAnime_name(anime_name);
    }
}
