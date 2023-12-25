package com.example.MYSQLConnect.entity;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name = "user_info")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "name")
    private String name;
    @Column(name = "password")
    private String password;

}
