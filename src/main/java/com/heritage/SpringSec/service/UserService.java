package com.heritage.SpringSec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.heritage.SpringSec.model.Users;
import com.heritage.SpringSec.repo.UserRepo;

@Service
public class UserService {

    @Autowired
     private UserRepo repo;

     private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);


    public Users registerUserService(Users user) {
        // In a real application, you would save the user to the database here
       user.setPassword(passwordEncoder.encode(user.getPassword()) );
       return  repo.save(user);
    } 
    
}
