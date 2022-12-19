package com.example.backend.ApiRequests;

import com.example.backend.Repositories.UserRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class UserRegisterForm {
    @Getter
    @Setter
    private String firstname;
    @Getter
    @Setter
    private String lastname;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String password;

    private static final Pattern VALID_EMAIL_ADDRESS = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static UserRepository userRepository;

    private boolean validMail(){
        Matcher matcher = VALID_EMAIL_ADDRESS.matcher(this.email) ;
        return matcher.find();
    }
     public boolean validUserRegistration(){
        if(!userRepository
                .findApplicationUsersByFirstnameAndLastnameAndEmail(
                        this.firstname,
                        this.lastname,
                        this.email
                ).isEmpty()
                && validMail()
        ){
            return true;
        }
        else {
            return false;
        }
     }
}
