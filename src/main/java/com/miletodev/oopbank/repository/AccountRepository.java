package com.miletodev.oopbank.repository;

import com.miletodev.oopbank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
