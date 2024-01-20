package com.luka.anirest.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luka.anirest.exception.UserNotFoundException;
import com.luka.anirest.exception.WrongPasswordException;
import com.luka.anirest.model.LoginResponse;
import com.luka.anirest.model.LoginUser;
import com.luka.anirest.security.UserPrincipal;
import com.luka.anirest.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

	private final AuthService authService;

	@PostMapping("/login")
	public LoginResponse login(@RequestBody @Valid LoginUser user)
			throws UserNotFoundException, WrongPasswordException {
		return authService.login(user);
	}
	
	@PostMapping("/validate")
	public UserPrincipal validate(@AuthenticationPrincipal UserPrincipal principal) {
		return authService.validate(principal);
	}
}