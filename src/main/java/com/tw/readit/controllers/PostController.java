package com.tw.readit.controllers;

import com.tw.readit.dto.LoginRequest;
import com.tw.readit.dto.RegisterRequest;
import com.tw.readit.dto.UpdateUsernameReq;
import com.tw.readit.entities.User;
import com.tw.readit.repositories.UserRepository;
import com.tw.readit.services.JwtService;
import com.tw.readit.services.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class PostController {

    private final JwtService service;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    PostController(JwtService service, UserRepository userRepository, PasswordEncoder passwordEncoder, UserService userService) {
        this.service = service;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        User user = new User(request.username(), passwordEncoder.encode(request.password()));
        userRepository.save(user);
        return "-->   successfully registered   <--";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {

        User user = userService.getUser(loginRequest.username());

        if (user == null) {
            return "User not found";
        }

        if (user.getUsername().equals(loginRequest.username())
                && passwordEncoder.matches(loginRequest.password(), user.getPassword())) {

            return service.generateToken(user.getUsername());
        }

        return "invalid credentials";
    }

    @GetMapping("/user")
    public User getUser(@RequestParam
                            String username) {
        return userService.getUser(username);
    }

    @PutMapping("/user")
    public String updateUsername(@RequestBody UpdateUsernameReq req) {
        userService.updateUsername(req.username(), req.id());
        return "updated successfully";
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestParam  String username) {
        userService.deleteUser(username);
        return "deleted successfully";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
