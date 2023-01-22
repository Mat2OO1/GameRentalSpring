package com.example.gamerental.repository;

import com.example.gamerental.model.Client;
import com.example.gamerental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findAll();

    List<Rental> getAllByClientId(Long id);


}
