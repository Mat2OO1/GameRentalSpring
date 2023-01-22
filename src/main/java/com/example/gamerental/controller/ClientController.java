package com.example.gamerental.controller;

import com.example.gamerental.model.Account;
import com.example.gamerental.model.Client;
import com.example.gamerental.model.Game;
import com.example.gamerental.model.RentalCount;
import com.example.gamerental.repository.AccountRepository;
import com.example.gamerental.repository.ClientRepository;
import com.example.gamerental.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class ClientController {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AccountRepository accountRepository;


    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClients(){
        return new ResponseEntity<>(clientRepository.findAll(), HttpStatus.OK);
    }
    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id){
        return new ResponseEntity<>(clientRepository.getClientById(id), HttpStatus.OK);
    }

    @GetMapping("/clients/rentals")
    public ResponseEntity<List<Object>> getClientsWithNumOfRentals(){
        return new ResponseEntity<>(clientRepository.getNumberOfRentalsPerClient(), HttpStatus.OK);
    }

    @GetMapping("/clients/canRent/{id}")
    public ResponseEntity<Boolean> getClientsWithNumOfRentals(@PathVariable Long id){
        return new ResponseEntity<>(clientRepository.canRent(id), HttpStatus.OK);
    }

    @GetMapping("/clients/lateRentals/{id}")
    public ResponseEntity<Boolean> anyLateRentals(@PathVariable Long id){
        return new ResponseEntity<>(clientRepository.lateRentals(id), HttpStatus.OK);
    }



    @PostMapping("/clients")
    public ResponseEntity<Client> addSaveClient(@RequestBody Client client){
        Account acc = new Account(client.getAccount().getEmail(), client.getAccount().getPassword());
        accountRepository.save(acc);
        return new ResponseEntity<>(clientRepository.save(new Client(
                client.getName(),
                client.getSurname(),
                client.getPhone_number(),
                client.getBirthdate(),
                client.isOnBlacklist(),
                acc

        )), HttpStatus.OK);
    }
    @PutMapping("/clients")
    public ResponseEntity<Client> editClient(@RequestBody Client client){
        accountRepository.save(client.getAccount());
        return new ResponseEntity<>(clientRepository.save(client), HttpStatus.OK);
    }

    @DeleteMapping("/clients")
    public ResponseEntity<Boolean> deleteClient(@RequestBody Client client){
        if(clientRepository.checkIfCanBeDeleted(client.getId())){
            clientRepository.delete(client);
            accountRepository.deleteAccountById(client.getAccount().getId());
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

    }
}
