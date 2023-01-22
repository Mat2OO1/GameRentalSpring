package com.example.gamerental.controller;

import com.example.gamerental.model.Reservation;
import com.example.gamerental.model.Worker;
import com.example.gamerental.repository.ReservationRepository;
import com.example.gamerental.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllGames(){
        return new ResponseEntity<>(reservationRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("clients/reservations/{id}")
    public ResponseEntity<List<Reservation>> getReservationByClientId(@PathVariable Long id){
        return new ResponseEntity<>(reservationRepository.getAllByClientId(id), HttpStatus.OK);
    }
}
