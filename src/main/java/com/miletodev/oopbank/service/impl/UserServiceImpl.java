package com.miletodev.oopbank.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.miletodev.oopbank.model.User;
import com.miletodev.oopbank.model.Account;
import com.miletodev.oopbank.repository.UserRepository;
import com.miletodev.oopbank.service.AccountFactory;
import com.miletodev.oopbank.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    private final UserRepository userRepository;
    private final AccountFactory accountFactory;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, AccountFactory accountFactory) {
        this.userRepository = userRepository;
        this.accountFactory = accountFactory;
    }

    @Override
    public User save(User user) {
        logger.info("Saving user with ID: {}", user.getId());
        Account account = accountFactory.createAccount(user);
        user.setAccount(account);
        User savedUser = userRepository.save(user);
        logger.info("User saved successfully with ID: {}", savedUser.getId());
        return savedUser;
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean authenticate(long id, String password) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get().checkPassword(password); // Assumindo que o método checkPassword existe no User
        }
        return false;
    }
    public boolean exists(long id) {
        if (userRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }
}
