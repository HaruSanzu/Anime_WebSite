package com.example.anime_website.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Anime_Multimedia")
public class Anime_Multimedia {
    @Id
    private Integer id;
    private String name;
    private String type;
    private String premiered;
    private String duration;
    private String studios;
    private Double score;
    private String genres;

    @OneToMany(mappedBy = "Anime_Multimedia", cascade = CascadeType.ALL)
    private List<Reviews> reviews = new ArrayList<>();

}
