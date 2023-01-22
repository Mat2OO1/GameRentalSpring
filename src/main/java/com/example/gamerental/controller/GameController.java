package com.example.gamerental.controller;

import com.example.gamerental.model.Client;
import com.example.gamerental.model.Rental;
import com.example.gamerental.repository.GameRepository;
import com.example.gamerental.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @GetMapping("/games")
    public ResponseEntity<List<Game>> getAllGames(){
        return new ResponseEntity<>(gameRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Game> getGameById(@PathVariable Long id){
        return new ResponseEntity<>(gameRepository.getGameById(id), HttpStatus.OK);
    }

}
