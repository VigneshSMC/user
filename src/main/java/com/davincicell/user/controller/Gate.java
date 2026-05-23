package com.davincicell.user.controller;

import com.davincicell.user.model.User;
import com.davincicell.user.request.LoginRequest;
import com.davincicell.user.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Gate {

    private final UserService userservice;

    Gate(UserService userservice) {
        this.userservice = userservice;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userservice.registerUser(user);
        return new ResponseEntity<>(user.getUsername(), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest user) {
        return new ResponseEntity<>(userservice.verify(user), HttpStatus.OK);
    }
}
