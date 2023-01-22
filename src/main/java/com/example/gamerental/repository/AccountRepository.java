package com.example.gamerental.repository;

import com.example.gamerental.model.Account;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AccountRepository extends JpaRepository<Account,Long> {

    @Transactional
    Long deleteAccountById(Long id);

}
