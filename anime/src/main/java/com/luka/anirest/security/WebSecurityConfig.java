package com.luka.anirest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
	
	@Bean
	SecurityFilterChain applicationSecurity(HttpSecurity http) throws Exception {
		return http
				.cors(cors -> cors.disable())
				.csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.formLogin(form -> form.disable())
				.securityMatcher("/**").authorizeHttpRequests(registry -> registry
						.requestMatchers("/**").permitAll()
						.requestMatchers("/anime/**").permitAll()
						).build();
	}

}