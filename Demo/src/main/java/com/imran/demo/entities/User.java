package com.imran.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "user_name", nullable = false, length = 100)
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private String userStatus;
}
