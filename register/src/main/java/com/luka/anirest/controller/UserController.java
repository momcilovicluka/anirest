package com.luka.anirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luka.anirest.exception.UserAlreadyExistsException;
import com.luka.anirest.exception.UserNotFoundException;
import com.luka.anirest.exception.WrongPasswordException;
import com.luka.anirest.model.LoginUser;
import com.luka.anirest.model.User;
import com.luka.anirest.service.UserService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public User returnUser(@RequestBody @Valid LoginUser user) throws UserNotFoundException, WrongPasswordException {
		return userService.returnUser(user);
	}

	@PostMapping("/register")
	public User addUser(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		return userService.addUser(user);
	}
}