package com.BookMyShow.controller;

import com.BookMyShow.entities.User;
import com.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;


@RestController
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/create-user")
    public void createUser(@RequestBody User user){
        userService.createUser(user);
    }

    @PutMapping(value = "update-user")
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }

    @GetMapping(value = "/{userId}")
    public User getUserById(@PathVariable("userId") Long userId){
        return userService.getUserById(userId);
    }

}
