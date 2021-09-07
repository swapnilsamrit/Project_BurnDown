package com.burn.com.burn.controller;

import com.burn.com.burn.exceptions.LoginException;
import com.burn.com.burn.servicecontract.LoginService;
import com.burn.com.burn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public boolean login(@RequestBody User user) throws LoginException {
        return loginService.validateUser(user);
    }
}
