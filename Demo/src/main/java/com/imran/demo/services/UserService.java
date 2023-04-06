package com.imran.demo.services;

import com.imran.demo.entities.User;
import com.imran.demo.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, String userId);
//
//    UserDto getUserById(Integer userId);
//
//    List<UserDto> getAllUsers();

    void deleteUser(String userName);

//    void deleteUser(Integer userId);
}
