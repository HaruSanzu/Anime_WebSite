package com.example.anime_website.repo;

import com.example.anime_website.models.Anime_Multimedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Anime_Repository extends JpaRepository<Anime_Multimedia, Long> {
   @Query(value = "SELECT * from \"Anime_Multimedia\" where name LIKE %?%",nativeQuery = true)
   List<Anime_Multimedia> findAnime_MultimediaByName(String name);


    @Query(value = "SELECT * from \"Anime_Multimedia\" ", nativeQuery = true)
    List<Anime_Multimedia> findAllAnimeNative();

}
