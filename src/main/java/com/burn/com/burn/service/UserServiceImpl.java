package com.burn.com.burn.service;

import com.burn.com.burn.repository.UserRepository;
import com.burn.com.burn.servicecontract.UserService;
import com.burn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepositoty;

    @Override
    public User getUser(int id) {
        return userRepositoty.findById(id).orElse(null);
    }

    @Override
    public User addUser(User user) {
        return userRepositoty.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoty.findAll();
    }
}
