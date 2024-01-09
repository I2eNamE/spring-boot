package com.example.MYSQLConnect.service;

import com.example.MYSQLConnect.entity.UserEntity;
import com.example.MYSQLConnect.model.LoginReq;
import com.example.MYSQLConnect.model.StringOnly;
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
    private final TokenService tokenService;


    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    public List<UserEntity> getAllUser() {
        return userRepo.findAll();
    }

    public Optional<UserEntity> getUserById(int id) {
        return userRepo.findById(id);
    }

    public UserEntity createUser(UserEntity user) {
        UserEntity opt = new UserEntity();
        opt.setEmail(user.getEmail());
        opt.setName(user.getName());
        opt.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepo.save(opt);
    }


    public String login(LoginReq login) throws Exception {
        String email = login.getEmail();
        String password = login.getPassword();
        if (Objects.isNull(email) || Objects.isNull(password)) {
            return "something null";
        }
        try {
            List<UserEntity> opt = userRepo.findByEmail(email);
            UserEntity user = opt.get(0);
            if (passwordEncoder.matches(password, user.getPassword())) {
                return tokenService.tokenize(user);
            } else {
                return "email or password incorrect";
            }
        } catch (Exception e) {
            return "email or password incorrect";
        }
    }


    public UserEntity findUserByName(StringOnly name){
        List<UserEntity> user = userRepo.findByName(name.getString());
        if (Objects.isNull(user)) {
            return null ;
        }
        else {
            return user.get(0);
        }
    }
}
