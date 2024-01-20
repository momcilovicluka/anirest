package com.luka.anirest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.luka.anirest.exception.UserNotFoundException;
import com.luka.anirest.exception.WrongPasswordException;
import com.luka.anirest.model.LoginResponse;
import com.luka.anirest.model.LoginUser;
import com.luka.anirest.model.PasswordlessUser;
import com.luka.anirest.model.User;
import com.luka.anirest.repository.UserRepository;
import com.luka.anirest.security.JwtIssuer;
import com.luka.anirest.security.UserPrincipal;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final JwtIssuer jwtIssuer;
	
	private final AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	public LoginResponse login(@Valid LoginUser user) throws UserNotFoundException, WrongPasswordException {
		returnUser(user);
		
		var authentication = authenticationManager.authenticate(
			new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		var principal = (UserPrincipal)authentication.getPrincipal();
		
		var roles = principal.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.toList();
		
		var token = jwtIssuer.issue(principal.getUserId(), principal.getUsername(), roles);

		return LoginResponse.builder()
				.accessToken(token)
				.build();
	}
	
	public UserPrincipal validate(UserPrincipal principal) {
		return principal;
	}

	private PasswordlessUser userToPasswordless(User user) {
		return new PasswordlessUser(user.getIdUser(), user.getName(), user.getSurname(), user.getUsername(),
				user.getEmail());
	}

	public PasswordlessUser returnUser(LoginUser user) throws UserNotFoundException, WrongPasswordException {
		Optional<User> repoUser = userRepository.findByUsername(user.getUsername());

		if (repoUser.isEmpty()) {
			PasswordlessUser userModel = new PasswordlessUser();
			userModel.setUsername(user.getUsername());
			throw new UserNotFoundException(userModel, "The user could not be found in the database");
		}

		return userToPasswordless(repoUser.get());
	}
}