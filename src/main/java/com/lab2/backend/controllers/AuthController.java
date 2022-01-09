package com.lab2.backend.controllers;

import com.lab2.backend.entity.User;
import com.lab2.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthController {


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<Optional<User>> login(@RequestParam String username, @RequestParam String password) {

        Optional<User> user = userRepository.findByUsername(username);

        if (user.get().getPassword().equals(password)) {
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, user.get().getPassword()).body(user);
        } else {
            return ResponseEntity.badRequest().header(HttpHeaders.AUTHORIZATION, user.get().getUsername()).body(user);
        }
    }

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestParam String username, @RequestParam String password) {

        User user = new User(username, password);
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(user);
    }
}
