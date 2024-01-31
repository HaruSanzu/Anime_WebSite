package com.example.anime_website.repo;

import com.example.anime_website.models.Anime_Multimedia;
import jakarta.persistence.QueryHint;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Anime_Repository extends JpaRepository<Anime_Multimedia, Long> {
   @Query(value = "SELECT * from \"Anime_Multimedia\" where name LIKE %?%",nativeQuery = true)
   List<Anime_Multimedia> findAnime_MultimediaByName(String name);


    @Query(value = "SELECT * from \"Anime_Multimedia\" ", nativeQuery = true)
    List<Anime_Multimedia> findAllAnimeNative();

    @Query(value = "SELECT * from \"Anime_Multimedia\" where type LIKE %?%",nativeQuery = true)
    List<Anime_Multimedia> findAnime_MultimediaByType(String type);

    @Query(value = "SELECT * from \"Anime_Multimedia\" where genres LIKE %?%",nativeQuery = true)
    List<Anime_Multimedia> findAnime_MultimediaByGenres(String genres);


    @Query(value = "INSERT INTO \"Anime_Multimedia\" (id,name, type, premiered, duration, studios, score, genres) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
            nativeQuery = true)
    @Modifying
    @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.FLUSH_MODE, value = "AUTO"))
    @Transactional
    Integer addAnime(@Param("id") Integer id, @Param("name") String name, @Param("type") String type,
                  @Param("premiered") String premiered, @Param("duration") String duration,
                  @Param("studios") String studios, @Param("score") Double score,
                  @Param("genres") String genres);


 @Modifying
 @Transactional
 @QueryHints(@QueryHint(name = org.hibernate.annotations.QueryHints.FLUSH_MODE, value = "AUTO"))
 @Query(value = "update Anime_Multimedia  SET name = :name, type = :type, premiered = :premiered, duration = :duration, studios = :studios, score = :score, genres = :genres WHERE id = :id", nativeQuery = true)
 Integer updateAnimeById(@Param("id") Integer id, @Param("name") String name, @Param("type") String type, @Param("premiered") String premiered,
                      @Param("duration") String duration, @Param("studios") String studios, @Param("score") Double score,
                      @Param("genres") String genres);

 Anime_Multimedia deleteAnime_MultimediaById(Integer id);
}


