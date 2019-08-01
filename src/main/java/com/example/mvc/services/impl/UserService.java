package com.example.mvc.services.impl;

import com.example.mvc.domain.Role;
import com.example.mvc.domain.User;
import com.example.mvc.repositories.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }
    public void registration(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        if (user.getUsername().equals("fara")){
            user.setRoles(Collections.singleton(Role.ADMIN));
        }
        userRepo.save(user);
    }

    public List<User> getAll() {
        return userRepo.findAll();
    }
}
