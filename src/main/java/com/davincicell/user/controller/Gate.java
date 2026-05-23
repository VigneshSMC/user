package com.davincicell.user.controller;

import com.davincicell.user.model.User;
import com.davincicell.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Gate {

    private final UserService userservice;

    Gate(UserService userservice) {
        this.userservice = userservice;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        userservice.registerUser(user);
        return new ResponseEntity<>(user.getUsername(), HttpStatus.CREATED);
    }

    @PostMapping("/auth/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return new ResponseEntity<>(userservice.verify(user), HttpStatus.OK);
    }

    @GetMapping(path = "/getData")
    public String getData() {
        return "HAHA";
    }
}
