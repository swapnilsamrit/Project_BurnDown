package com.burn.com.burn.servicecontract;

import com.burn.com.burn.exceptions.UserException;
import com.burn.model.User;

import java.util.List;

public interface UserService {
    /**
     * fetch the user based on id rpovide
     *
     * @param id
     * @return user object
     */
    User getUser(int id);

    User save(User user);

    List<User> getAllUsers();

    User update(User user) throws UserException;

    void delete(int id) throws UserException;

    boolean login(User user) throws UserException;
}
