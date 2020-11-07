package com.example.sb.basicspringboot.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sb.basicspringboot.auth.payload.ApiResponse;
import com.example.sb.basicspringboot.user.model.User;
import com.example.sb.basicspringboot.user.model.UserDto;
import com.example.sb.basicspringboot.user.service.UserService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    @ApiOperation(value = "Add User by User data",
    			notes = "Add specific user to db.",
    			response = User.class)
    public ApiResponse saveUser(@RequestBody UserDto user){
        return new ApiResponse(HttpStatus.OK.value(), "User saved successfully.",userService.save(user));
    }

    @PostMapping("/getAll")
    public ApiResponse listUser(){
        return new ApiResponse(HttpStatus.OK.value(), "User list fetched successfully.",userService.findAll());
    }

    @PostMapping("/fetchUser")
    public ApiResponse getOne(@RequestBody UserDto userDto){
        return new ApiResponse(HttpStatus.OK.value(), "User fetched successfully.",userService.findById(userDto.getId()));
    }

    @PostMapping("/updateUser")
    public ApiResponse update(@RequestBody UserDto userDto) {
        return new ApiResponse(HttpStatus.OK.value(), "User updated successfully.",userService.update(userDto));
    }

    @PostMapping("/deleteUser")
    public ApiResponse delete(@RequestBody UserDto userDto) {
        userService.delete(userDto.getId());
        return new ApiResponse(HttpStatus.OK.value(), "User deleted successfully.", null);
    }



}