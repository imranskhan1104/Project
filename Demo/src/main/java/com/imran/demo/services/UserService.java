package com.imran.demo.services;

import com.imran.demo.payloads.UserDto;
import org.apache.catalina.User;

import java.lang.reflect.Array;
import java.util.List;

public interface UserService {

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto, String userId);

    UserDto getUserByUserName(String userName);
//
//    List<UserDto> getAllUsers();
    boolean createUserByArray(UserDto[] userDto);
    boolean createUserByList(List<UserDto> listOfUser);
    void deleteUser(String userName);
}
