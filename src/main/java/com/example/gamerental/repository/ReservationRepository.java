package com.example.gamerental.repository;

import com.example.gamerental.model.Game;
import com.example.gamerental.model.Rental;
import com.example.gamerental.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    List<Reservation> findAll();

    List<Reservation> getAllByClientId(Long id);
}
