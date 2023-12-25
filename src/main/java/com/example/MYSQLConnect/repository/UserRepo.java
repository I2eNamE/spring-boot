package com.example.MYSQLConnect.repository;

import com.example.MYSQLConnect.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity,Integer>{
    List<UserEntity> findByEmail(String emailAddress);


    boolean existsByEmail(String emailAddress);
}
