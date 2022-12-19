package com.example.backend.Repositories;

import com.example.backend.Models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUserID(long userID);
    List<ApplicationUser> findApplicationUsersByFirstnameAndLastnameAndEmail(
            String firstname,
            String lastname,
            String email
    );
}
