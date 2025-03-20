package com.SETTribe.Controller;

import com.SETTribe.DTO.LoginRequest;
import com.SETTribe.DTO.RegisterRequest;
import com.SETTribe.Model.User;
import com.SETTribe.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        return userService.registerUser(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {
        User user = userService.loginUser(request.getEmail(), request.getPassword());
        return (user != null) ? "Login successful!" : "Invalid credentials!";
    }
}