package com.example.anime_website.repo;

import com.example.anime_website.models.Reviews;
import jakarta.persistence.QueryHint;
import jakarta.transaction.Transactional;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Review_Repository extends JpaRepository<Reviews, Long> {
    @Query(value = "INSERT INTO \"reviews\" (id,review,anime_name,username) " +
            "VALUES (?, ?, ?, ?)",
            nativeQuery = true)
    @Modifying
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.FLUSH_MODE, value = "AUTO"))
    @Transactional
    Integer addReview(@Param("id") Integer id, @Param("review") String review, @Param("anime_name") String anime_name,
                     @Param("username") String username);


    @Query(value = "SELECT * from \"reviews\" ",nativeQuery = true)
    List<Reviews> findAllReviews();


    @Query(value = "SELECT * from \"reviews\" where anime_name like %?% ", nativeQuery = true)
    List<Reviews> findReviewsByAnime_name(String anime_name);
}
