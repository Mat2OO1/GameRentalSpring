package com.example.gamerental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String paymentMethod;
    private boolean isInvoice;
    @OneToOne
    private Rental rental;
    @OneToOne
    private Receipt receipt;
}
