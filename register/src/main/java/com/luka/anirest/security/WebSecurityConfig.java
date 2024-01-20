package com.luka.anirest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	
	private final CustomUserDetailsService customUserDetailsService;
	
	@Bean
	SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
		return http
				.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				.cors(cors -> cors.disable())
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.formLogin(form -> form.disable())
				.securityMatcher("/**").authorizeHttpRequests(registry -> registry
						.requestMatchers("/").permitAll()
						.requestMatchers("/auth/validate").authenticated()
						.requestMatchers("/auth/**").permitAll()
						.requestMatchers("/user/**").permitAll()
						//.requestMatchers("/user/**").permitAll()
						.anyRequest().authenticated()
						).build();
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		 http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(customUserDetailsService)
				.passwordEncoder(passwordEncoder());
		 return http.getSharedObject(AuthenticationManagerBuilder.class).build();
	}
}