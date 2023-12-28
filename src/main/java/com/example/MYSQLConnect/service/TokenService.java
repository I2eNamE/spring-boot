package com.example.MYSQLConnect.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.MYSQLConnect.entity.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public String tokenize(UserEntity user){
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create()
                .withIssuer("auth0")
                .sign(algorithm);
        return token;
    }

}
