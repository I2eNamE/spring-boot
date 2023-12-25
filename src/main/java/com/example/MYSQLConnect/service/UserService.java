package com.example.MYSQLConnect.service;

import com.example.MYSQLConnect.entity.UserEntity;
import com.example.MYSQLConnect.model.LoginModel;
import com.example.MYSQLConnect.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        ;
    }

    public List<UserEntity> getAllUser(){
        return userRepo.findAll();
    }
    public Optional<UserEntity> getUserById(int id){return userRepo.findById(id);}

    public UserEntity createUser(UserEntity user){
        UserEntity opt = new UserEntity();
        opt.setEmail(user.getEmail());
        opt.setName(user.getName());
        opt.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(opt);
    }



    public String login(LoginModel login){
        if(Objects.isNull(login.getEmail()) ||Objects.isNull(login.getPassword())){return "email or password is null";}
        return login.getEmail().toString()+login.getPassword().toString();
    }
}
