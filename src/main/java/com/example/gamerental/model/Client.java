package com.example.gamerental.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phone_number;
    private Date birthdate;
    private boolean isOnBlacklist;
    @OneToOne
    private Account account;

    public Client(String name, String surname, String phone_number, Date birthdate, boolean isOnBlacklist, Account account) {
        this.name = name;
        this.surname = surname;
        this.phone_number = phone_number;
        this.birthdate = birthdate;
        this.isOnBlacklist = isOnBlacklist;
        this.account = account;
    }
}
