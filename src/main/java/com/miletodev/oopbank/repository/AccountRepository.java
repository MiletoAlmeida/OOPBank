package com.miletodev.oopbank.repository;

import com.miletodev.oopbank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByNumber(long accountNumber);
}
