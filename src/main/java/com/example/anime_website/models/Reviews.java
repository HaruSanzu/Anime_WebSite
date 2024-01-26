package com.example.anime_website.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    private Integer id;
    private String review;

    @ManyToOne(fetch = FetchType.LAZY)
    private Anime_Multimedia anime_multimedia;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
}
