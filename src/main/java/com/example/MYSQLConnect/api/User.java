package com.example.MYSQLConnect.api;


import com.example.MYSQLConnect.entity.UserEntity;
import com.example.MYSQLConnect.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class User {
    private final UserService userService;

    public User(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserEntity> getAllUser(){
        List<UserEntity> response = userService.getAllUser();
        return response;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserEntity>> getUserById(@PathVariable int id){
        Optional<UserEntity> response = userService.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity body) {
        UserEntity customer = userService.createUser(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }



}
