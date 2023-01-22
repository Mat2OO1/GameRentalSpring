package com.example.gamerental.repository;

import com.example.gamerental.model.Client;
import com.example.gamerental.model.Game;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {

    List<Game> findAll();

    Game getGameById(Long id);

}
