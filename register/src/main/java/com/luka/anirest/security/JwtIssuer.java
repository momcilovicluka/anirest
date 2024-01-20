package com.luka.anirest.security;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtIssuer {
	
	private final JwtProperties pJwtProperties;

	public String issue(long userId, String username, List<String> roles) {
		return JWT.create()
				.withSubject(String.valueOf(userId))
				.withExpiresAt(Instant.now().plus(Duration.of(1, ChronoUnit.DAYS)))
				.withClaim("username", username)
				.withClaim("authorities", roles)
				.sign(Algorithm.HMAC256(pJwtProperties.getSecretKey()));
	}
}