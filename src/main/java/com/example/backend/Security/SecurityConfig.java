package com.example.backend.Security;

import com.example.backend.ApiRequests.UserRegisterForm;
import com.example.backend.Enums.ApplicationRole;
import com.example.backend.Models.ApplicationUser;
import com.example.backend.Repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

import static com.example.backend.Enums.ApplicationRole.ADMIN;
import static com.example.backend.Enums.ApplicationRole.NORMAL_USER;

@Configuration
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
public class SecurityConfig {

    private static UserRepository userRepository;

    public SecurityFilterChain SecurityFilter(HttpSecurity httpSecurity) throws Exception {
        return null;
    }

    public InMemoryUserDetailsManager userDetailsManager(long userID){
        ApplicationUser user = userRepository.findByUserID(userID) ;
        UserDetails userDetails = User
                .withUsername(user.getEmail())
                .password(passwordEncoder().encode(user.getPassword()))
//                .roles(ADMIN.name(),NORMAL_USER.name())
                .roles(user.getRoles().toString())
                .build();
        return new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(16);
    }
}
