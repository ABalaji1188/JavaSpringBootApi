package com.example.SpringSecurity.Services;

import com.example.SpringSecurity.Model.User;
import com.example.SpringSecurity.Model.UserPrincipal;
import com.example.SpringSecurity.repo.UserDeatilsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDeatilsServices implements UserDetailsService {

    @Autowired
    UserDeatilsRepo userDeatilsRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userDeatilsRepo.getByUsername(username);
        if(user==null){
            throw  new UsernameNotFoundException("user not found");
        }
        else{
            return  new UserPrincipal(user);
        }
    }
}
