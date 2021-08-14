package com.burn.com.burn.servicecontract;

import com.burn.model.User;

import java.util.List;

public interface UserService {
    User getUser(int id);
    User addUser(User user);
    List<User> getAllUsers();
}
