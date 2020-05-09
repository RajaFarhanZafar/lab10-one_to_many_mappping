package com.example.lab10one_to_many_mappping.controllers;

import com.example.lab10one_to_many_mappping.service.ApplicationUserService;
import com.example.lab10one_to_many_mappping.service.JavaUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import com.example.lab10one_to_many_mappping.entity.ApplicationUser;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JavaUtilService jwtUtil;
    @Autowired
    private ApplicationUserService userService;
    @PostMapping
    public String login(@RequestBody ApplicationUser users)throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
        }catch (Exception e){
            throw new Exception("Invalid Credentials");
        }
       return jwtUtil.generateToken(users.getUsername());
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody ApplicationUser user){
            userService.save(user);
            return new ResponseEntity<String>("User Created", HttpStatus.CREATED);
    }
}
