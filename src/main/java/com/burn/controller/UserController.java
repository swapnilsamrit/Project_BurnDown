package com.burn.controller;


import com.burn.com.burn.exceptions.UserException;
import com.burn.com.burn.servicecontract.UserService;
import com.burn.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/get/{id}")
    public User get(@PathVariable(value = "id") Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User user) throws UserException {
        return userService.update(user);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable(value = "id") Integer id){
        try {
            userService.delete(id);
            return  ResponseEntity.status(HttpStatus.OK).build();
        } catch (UserException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PutMapping("/login")
    public ResponseEntity login(@RequestBody User user){
        try {
            boolean response=userService.login(user);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (UserException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
