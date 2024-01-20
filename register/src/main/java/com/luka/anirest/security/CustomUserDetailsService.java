package com.luka.anirest.security;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.luka.anirest.exception.UserNotFoundException;
import com.luka.anirest.model.User;
import com.luka.anirest.service.UserService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	private final UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User loginUser = new User();
		loginUser.setUsername(username);
		
		User user = null;
		
		try {
			user = userService.returnUser(loginUser);
			System.out.println(user.getUsername() + user.getPassword());
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
		
		return UserPrincipal.builder()
				.userId(user.getIdUser())
				.username(user.getUsername())
				.password(user.getPassword())
				.authorities(List.of(new SimpleGrantedAuthority("USER")))
				.build();
	}

}