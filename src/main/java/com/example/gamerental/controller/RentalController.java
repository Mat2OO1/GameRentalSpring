package com.example.gamerental.controller;

import com.example.gamerental.model.*;
import com.example.gamerental.repository.GameRepository;
import com.example.gamerental.repository.RentalRepository;
import com.example.gamerental.repository.WorkerRepository;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RentalController {

    @Autowired
    RentalRepository rentalRepository;
    @Autowired
    WorkerRepository workerRepository;
    @Autowired
    GameRepository gameRepository;


    @GetMapping("/rentals")
    public ResponseEntity<List<Rental>> getAllGames(){
        return new ResponseEntity<>(rentalRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/clients/rentals/{id}")
    public ResponseEntity<List<Rental>> getRentalsByClientId(@PathVariable Long id){
        return new ResponseEntity<>(rentalRepository.getAllByClientId(id), HttpStatus.OK);
    }
    @PostMapping("/rentals/add")
    public ResponseEntity<Rental> addRental(@RequestBody Rental rental){
        gameRepository.save(rental.getGame());
        return new ResponseEntity<>(rentalRepository.save(new Rental(
                rental.getRentalDate(),
                rental.getReturnDate(),
                rental.getCost(),
                rental.getPenalty(),
                rental.getDiscount(),
                rental.isPaid(),
                rental.getClient(),
                null,
                rental.getGame()
        )), HttpStatus.OK);
    }
}
