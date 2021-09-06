package com.burn.com.burn.servicecontract;

import com.burn.com.burn.exceptions.LoginException;
import com.burn.model.User;

public interface LoginService {
    User getUser(int id);
    boolean validateUser(User user) throws LoginException;
}
