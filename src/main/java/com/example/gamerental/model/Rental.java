package com.example.gamerental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date rentalDate;
    private Date returnDate;
    private double cost;
    private double penalty;
    private double discount;
    private boolean isPaid;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Worker worker;
    @ManyToOne
    private Game game;
    @OneToOne
    private Reservation reservation;
    @OneToOne
    private Payment payment;

    public Rental(Date rentalDate, Date returnDate, double cost, double penalty, double discount, boolean isPaid, Client client, Worker worker, Game game, Reservation reservation, Payment payment) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.cost = cost;
        this.penalty = penalty;
        this.discount = discount;
        this.isPaid = isPaid;
        this.client = client;
        this.worker = worker;
        this.game = game;
        this.reservation = reservation;
        this.payment = payment;
    }

    public Rental(Date rentalDate, Date returnDate, double cost, double penalty, double discount, boolean isPaid, Client client, Worker worker, Game game) {
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.cost = cost;
        this.penalty = penalty;
        this.discount = discount;
        this.isPaid = isPaid;
        this.client = client;
        this.worker = worker;
        this.game = game;
    }
}
