package com.example.backend.Models;

import com.example.backend.Enums.ApplicationRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;

@Entity
@Table(name = "ApplicationUser")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userID;

    @Column(name = "username")
    @NonNull
    private String username;

    @Column(name = "lastname")
    private String lastname;

    @NonNull
    private String password;

    @Column(name = "state")
    private boolean state = false ;

    @ElementCollection(targetClass = ApplicationRole.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "mapUsersRoles")
    @Column(name = "Roles")
    private HashSet<ApplicationRole> roles ;
}
