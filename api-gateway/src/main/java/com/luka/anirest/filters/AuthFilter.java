package com.luka.anirest.filters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URL;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.luka.anirest.model.SimplePrincipal;

public class AuthFilter extends AbstractGatewayFilterFactory<AuthFilter.Config> {

	public static class Config {

	}

	public AuthFilter() {
		super(Config.class);
	}

	@Override
	public GatewayFilter apply(Config config) {
		return (exchange, chain) -> {
			String authHeaders = "";
			try {
				authHeaders = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
			} catch (Exception e) {
				throw new RuntimeException("No Authorization header = no access");
			}

			URL url = null;
			try {
				url = URI.create("http://localhost:8765/auth/validate").toURL();
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}

			HttpURLConnection conn = null;
			try {
				conn = (HttpURLConnection) url.openConnection();
			} catch (IOException e) {
				e.printStackTrace();
			}

			conn.setRequestProperty("Authorization", authHeaders);
			conn.setRequestProperty("Content-Type", "application/json");

			try {
				conn.setRequestMethod("POST");
			} catch (ProtocolException e) {
				e.printStackTrace();
			}

			BufferedReader in = null;
			try {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (in == null)
				throw new RuntimeException("You didn't say the magic word");

			String output;
			StringBuffer response = new StringBuffer();
			try {
				while ((output = in.readLine()) != null) {
					response.append(output);
				}
			} catch (IOException e) {
				e.printStackTrace();
				throw new RuntimeException("You didn't say the magic word");
			}

			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

			ObjectMapper objectMapper = new ObjectMapper();
			JsonNode jsonNode = null;
			try {
				jsonNode = objectMapper.readTree(response.toString());
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			int userId = jsonNode.get("userId").asInt();
			String username = jsonNode.get("username").asText();

			SimplePrincipal principal = SimplePrincipal.builder().id(userId).username(username).build();

			String principalJson = null;
			try {
				principalJson = objectMapper.writeValueAsString(principal);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}

			ServerHttpRequest mutatedRequest = exchange.getRequest().mutate()
					.header("principal", principalJson)
					.build();

			return chain.filter(exchange.mutate().request(mutatedRequest).build());
		};
	}
}