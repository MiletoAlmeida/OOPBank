package com.miletodev.oopbank.service;

import com.miletodev.oopbank.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends CrudService <User, Long> {
}
