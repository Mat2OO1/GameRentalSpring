package com.example.gamerental.controller;

import com.example.gamerental.model.Client;
import com.example.gamerental.model.Worker;
import com.example.gamerental.repository.ClientRepository;
import com.example.gamerental.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WorkerController {

    @Autowired
    WorkerRepository workerRepository;

    @GetMapping("/workers")
    public ResponseEntity<List<Worker>> getAllWorkers(){
        return new ResponseEntity<>(workerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/workers/{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id){
        return new ResponseEntity<>(workerRepository.getWorkerById(id), HttpStatus.OK);
    }
}
