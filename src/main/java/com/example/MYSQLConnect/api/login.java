package com.example.MYSQLConnect.api;

import com.example.MYSQLConnect.model.LoginModel;
import com.example.MYSQLConnect.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")

public class login {

    private final UserService userService;

    public login(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String login(@RequestBody LoginModel login) throws Exception {
        String res = userService.login(login);
        return res;
    }
}
