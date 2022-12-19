package com.example.backend.ApiRequests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterForm {
    private String firstname;
    private String lastname;
    private String password;
}
