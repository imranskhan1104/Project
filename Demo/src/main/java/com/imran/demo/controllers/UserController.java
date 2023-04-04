package com.imran.demo.controllers;

import com.imran.demo.payloads.ApiResponse;
import com.imran.demo.payloads.UserDto;
import com.imran.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createUserDto = this.userService.createUser(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uId) {
        UserDto updateuser = this.userService.updateUser(userDto, uId);
        return ResponseEntity.ok(updateuser);
    }


    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer uId) {
        this.userService.deleteUser(uId);
//        Map<String, Object> map = new HashMap<>();
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);

    }


    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAlluser() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }


    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Integer uId) {
        return ResponseEntity.ok(this.userService.getUserById(uId));
    }

}
