package com.imran.demo.controllers;

import com.imran.demo.response.ApiResponse;
import com.imran.demo.payloads.UserDto;
import com.imran.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/{userName}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable("userName") String userName) {
        UserDto updateuser = this.userService.updateUser(userDto, userName);
        return ResponseEntity.ok(updateuser);
    }


    @DeleteMapping("/{userName}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userName") String userName) {
        this.userService.deleteUser(userName);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
    }


//    @GetMapping("/")
//    public ResponseEntity<List<UserDto>> getAlluser() {
//        return ResponseEntity.ok(this.userService.getAllUsers());
//    }


    @GetMapping("/{userName}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userName") String userName) {
        return ResponseEntity.ok(this.userService.getUserByUserName(userName));
    }

}
