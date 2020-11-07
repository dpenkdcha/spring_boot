package com.example.sb.basicspringboot.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.sb.basicspringboot.user.model.User;
import com.example.sb.basicspringboot.user.model.UserDto;

@Service
public interface UserService {

	User save(UserDto user);

	List<User> findAll();
    
	void delete(int id);

    User findOne(String username);

    User findById(int id);

    UserDto update(UserDto userDto);

}
