package com.example.gamerental.repository;

import com.example.gamerental.model.Game;
import com.example.gamerental.model.Worker;
import org.hibernate.jdbc.Work;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker,Long> {

    List<Worker> findAll();

    Worker getWorkerById(Long id);

    @Query(nativeQuery=true, value="SELECT *  FROM worker ORDER BY random() LIMIT 1")
    Worker randomWorker();
}
