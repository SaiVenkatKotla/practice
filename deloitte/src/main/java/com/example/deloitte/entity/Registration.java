package com.example.deloitte.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "t_registration")
@Data
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
}
