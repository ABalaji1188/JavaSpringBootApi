package com.example.SpringSecurity.repo;

import com.example.SpringSecurity.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserDeatilsRepo extends JpaRepository<User, Integer> {


    User getByUsername(String username);

}
