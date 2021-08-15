package com.burn.com.burn.service;

import com.burn.com.burn.exceptions.UserException;
import com.burn.com.burn.repository.UserRepository;
import com.burn.com.burn.servicecontract.UserService;
import com.burn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Service layer for the user. all the business logic goes here.
 * controller request this class to serv the request, this business layer will call to
 * the user repository class for DB related operation. also, it will apply the logic on req/res.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepositoty;

    @Override
    public User getUser(int id) {
        return userRepositoty.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        user.setPassword(encodepassword().encode(user.getPassword()));
        return userRepositoty.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepositoty.findAll();
    }

    @Override
    public User update(User user) throws UserException {
        User user1 = userRepositoty.findById(user.getId()).orElse(null);
        if (Objects.isNull(user1))
            throw new UserException("User " + user.getId() + " not available");
        return userRepositoty.save(user);
    }

    @Override
    public void delete(int id) throws UserException {
        userRepositoty.deleteById(id);
    }

    /**
     * validate the user
     * @param user
     * @return true or false
     * @throws UserException
     */
    @Override
    public boolean login(User user) throws UserException {
        User user1 = userRepositoty.findByUsername(user.getUsername());
        if (Objects.nonNull(user1)) {
            return validate(user1, user);
        } else {
            throw new UserException("Invalid user");
        }
    }

    /**
     * validate the user fetched from the DB
     * @param optionalUser user object fetched from DB
     * @param user User object from request
     * @return true or false
     */
    private boolean validate(User optionalUser, User user) {
        if (optionalUser.getUsername().equalsIgnoreCase(user.getUsername())) {
            if (optionalUser.getPassword().equals(user.getPassword())) {
                System.out.println("Valid User!");
                return true;
            }
        }
        return false;
    }
    @Bean
    public BCryptPasswordEncoder encodepassword(){
        return new BCryptPasswordEncoder();
    }
}
