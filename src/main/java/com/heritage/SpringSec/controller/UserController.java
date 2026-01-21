package com.heritage.SpringSec.controller;

import org.springframework.web.bind.annotation.RestController;

import com.heritage.SpringSec.model.Users;
import com.heritage.SpringSec.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class UserController {
 
   @Autowired
   private UserService service;

    @PostMapping("/register")
    public Users registerUser(@RequestBody Users user) {
        // In a real application, you would save the user to the database here
        return service.registerUserService(user);
    } 

    @PostMapping("/login")
    public String loginUser(@RequestBody Users user) {
        // In a real application, you would authenticate the user here
        System.out.println("user logged in: " + user.getUsername());
        return "success";
    }
    

}