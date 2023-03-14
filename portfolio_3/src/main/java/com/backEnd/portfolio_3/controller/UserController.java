/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.backEnd.portfolio_3.controller;

import com.backEnd.portfolio_3.model.User;
import com.backEnd.portfolio_3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin()
public class UserController {
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData){
        System.out.println(userData);
        User user = userRepository.findByUserId(userData.getUserId());
        if(user.getPassword().equals(userData.getPassword()))
            return ResponseEntity.ok(user);
        return(ResponseEntity<?>)ResponseEntity.internalServerError();
    }
    
}
