package com.imran.demo.repositories;

import com.imran.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
//#it is responsilbe to work with User class and primariy key will be user id
}
