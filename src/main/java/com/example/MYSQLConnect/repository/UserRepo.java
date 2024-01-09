package com.example.MYSQLConnect.repository;

import com.example.MYSQLConnect.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    List<UserEntity> findByEmail(String emailAddress);

    @Query("FROM UserEntity WHERE name = ?1")
    List<UserEntity> findByName(String name);


}
