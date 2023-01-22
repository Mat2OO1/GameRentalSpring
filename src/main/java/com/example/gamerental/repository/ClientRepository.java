package com.example.gamerental.repository;

import com.example.gamerental.model.Client;
import com.example.gamerental.model.Game;
import com.example.gamerental.model.RentalCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ClientRepository extends JpaRepository<Client,Long> {

    List<Client> findAll();

    Client getClientById(Long id);

    @Query(value = "SELECT COUNT(*) != 0 FROM client where client.id = ?1",
            nativeQuery = true )
    Boolean checkIfClientExists(Long id);


    @Query(value = "SELECT COUNT(*) = 0 FROM client join rental on client.id = rental.client_id join reservation on client.id = reservation.client_id where client.id = ?1",
    nativeQuery = true )
    Boolean checkIfCanBeDeleted(Long id);

    @Query(value = "SELECT COUNT(*) <=3 FROM client join rental on client.id = rental.client_id where client.id = ?1",
            nativeQuery = true )
    Boolean canRent(Long id);

    @Query(value = "SELECT COUNT(*) > 0= FROM client join rental on client.id = rental.client_id where client.id = ?1 and rental.return_date > now()",
            nativeQuery = true )
    Boolean lateRentals(Long id);

    @Query(value = "SELECT c.id,COUNT(rental.id) FROM client c left join rental on c.id = rental.client_id GROUP BY c.id",
    nativeQuery = true)
    List<Object> getNumberOfRentalsPerClient();


}
