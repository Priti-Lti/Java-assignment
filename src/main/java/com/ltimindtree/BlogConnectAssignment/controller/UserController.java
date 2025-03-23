package com.ltimindtree.BlogConnectAssignment.controller;

import com.ltimindtree.BlogConnectAssignment.dto.AuthRequest;
import com.ltimindtree.BlogConnectAssignment.dto.AuthResponse;
import com.ltimindtree.BlogConnectAssignment.entity.User;
import com.ltimindtree.BlogConnectAssignment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> loginUser(@RequestBody AuthRequest authRequest) {
        String token = userService.authenticateUser(authRequest.getUsername(), authRequest.getPassword());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAccessToken(token);
        return ResponseEntity.ok(authResponse);
    }
}
