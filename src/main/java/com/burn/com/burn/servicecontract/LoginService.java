package com.burn.com.burn.servicecontract;

import com.burn.com.burn.exceptions.LoginException;
import com.burn.com.burn.model.User;

public interface LoginService {
    boolean validateUser(User user) throws LoginException;
}
