package com.burn.com.burn.service;

import com.burn.com.burn.exceptions.LoginException;
import com.burn.com.burn.model.User;
import com.burn.com.burn.mongorepo.MongoRepositoryService;
import com.burn.com.burn.repository.LoginRepository;
import com.burn.com.burn.servicecontract.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepository repository;
    @Autowired
    MongoRepositoryService mongoRepositoryService;


    @Override
    public boolean validateUser(User vUser) throws LoginException {
        System.out.println("User Requested "+vUser.getUsername());
        User user = repository.findByUsername(vUser.getUsername());
        return validate(user, vUser);
    }

    private boolean validate(User user1, User user) throws LoginException {
        if (Objects.nonNull(user1)) {
            System.out.println("User available in DB");
            if (user1.getUsername().equals(user.getUsername())) {
                System.out.println("Valid user! Login Success");
                //TODO do more validation based on security
                return true;
            }else {
                throw new LoginException("Unauthorized User");
            }
        }
        return false;
    }
}
