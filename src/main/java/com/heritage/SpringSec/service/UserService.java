package com.heritage.SpringSec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.heritage.SpringSec.model.Users;
import com.heritage.SpringSec.repo.UserRepo;

@Service
public class UserService {

    @Autowired
     private UserRepo repo;

     @Autowired
     private JWTService jwtService; 

     @Autowired
     AuthenticationManager authManager;

     private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);


    public Users registerUserService(Users user) {
        // In a real application, you would save the user to the database here
       user.setPassword(passwordEncoder.encode(user.getPassword()) );
       return  repo.save(user);
    } 

    public String loginUserService(Users user) {
        // In a real application, you would authenticate the user here
        Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if (authentication.isAuthenticated())
           return jwtService.generateToken(user.getUsername());
        else
            return "Invalid user credentials";

    }
    
}
