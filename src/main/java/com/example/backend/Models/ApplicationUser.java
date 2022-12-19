package com.example.backend.Models;

import com.example.backend.Enums.ApplicationRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

import static com.example.backend.Enums.ApplicationRole.NORMAL_USER;

@Entity
@Table(name = "ApplicationUser")
@Setter
@Getter
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    @Column(name = "firstname")
    @NonNull
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email", unique = true)
    private String email;

    @NonNull
    private String password;

    @Column(name = "state")
    private boolean state = false ;

    @ElementCollection(targetClass = ApplicationRole.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "mapUsersRoles")
    @Column(name = "Roles")
    private HashSet<String> roles ;

    public ApplicationUser(@NonNull String firstname, String lastname, String email, @NonNull String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.roles.add(NORMAL_USER.name());
    }
}
