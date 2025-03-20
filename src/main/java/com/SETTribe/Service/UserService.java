package com.SETTribe.Service;

import com.SETTribe.DTO.RegisterRequest;
import com.SETTribe.Model.User;
import com.SETTribe.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String registerUser(RegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return "Password and Confirm Password do not match!";
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setMiddleName(request.getMiddleName());
        user.setLastName(request.getLastName());
        user.setFullName(request.getFirstName() + " " + request.getMiddleName() + " " + request.getLastName());
        user.setMobileNumber(request.getMobileNumber());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        userRepository.save(user);
        return "User registered successfully!";
    }

    public User loginUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}