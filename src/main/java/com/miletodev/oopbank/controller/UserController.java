package com.miletodev.oopbank.controller;

import com.miletodev.oopbank.model.User;
import com.miletodev.oopbank.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing user-related operations such as registration and login.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * Endpoint for registering a new user.
     *
     * @param user The user object containing user details.
     * @return ResponseEntity with a success message.
     */
    @RequestMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userServiceImpl.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    /**
     * Endpoint for user login.
     *
     * @param id The ID of the user.
     * @param password The password of the user.
     * @return ResponseEntity with a success message if authenticated, otherwise an error message.
     */
    @RequestMapping("/login")
    public ResponseEntity<String> login(@RequestParam long id, @RequestParam String password) {
        boolean isAuthenticated = userServiceImpl.authenticate(id, password);
        if (isAuthenticated) {
            return ResponseEntity.ok("User logged in successfully!");
        } else {
            return ResponseEntity.status(401).body("Invalid credentials!");
        }
    }
}