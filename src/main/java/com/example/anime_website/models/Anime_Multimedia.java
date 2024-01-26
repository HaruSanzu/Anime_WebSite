package com.example.anime_website.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

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
    private String reviews;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "anime_id")
    @JsonIgnore
    private List<Reviews> review = new ArrayList<>();

}
