package com.miletodev.oopbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miletodev.oopbank.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
