package com.miletodev.oopbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.miletodev.oopbank.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
