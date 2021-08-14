package com.burn.controller;


import com.burn.com.burn.servicecontract.UserService;
import com.burn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User add(@RequestBody User user){
        System.out.println("User "+user);
        return userService.addUser(user);
    }
    @GetMapping("/get/{id}")
    public User get(@PathVariable(value = "id") Integer id){
        return userService.getUser(id);
    }
    @GetMapping("/getAll")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
