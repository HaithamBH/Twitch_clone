package com.example.backend.Controller;

import com.example.backend.ApiRequests.UserRegisterForm;
import com.example.backend.Models.ApplicationUser;
import com.example.backend.Repositories.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/users")
public class UserController {

    public static UserRepository userRepository;

    @PostMapping("/register")
    public void UserRegister(@RequestBody UserRegisterForm userRegisterForm){

    }
}
