package com.example.gamerental.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private double value;
    private String description;
    private int pegi;
    @ManyToOne
    private Platform platform;
    private boolean is_rented;
    private boolean is_reserved;
    private String imgpath;
}
