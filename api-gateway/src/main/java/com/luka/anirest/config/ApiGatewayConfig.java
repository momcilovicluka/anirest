package com.luka.anirest.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.luka.anirest.filters.AuthFilter;

@Configuration
public class ApiGatewayConfig {

	@Bean
	AuthFilter authFilter() {
		return new AuthFilter();
	}

	@Bean
	RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
		.route(p -> p.path("/auth/**").uri("lb://register"))
		.route(p -> p.path("/user/**").uri("lb://register"))
		.route(p -> p.path("/anime/**").filters(f -> f.filter(authFilter().apply(new AuthFilter.Config()))).uri("lb://anime"))
		.route(p -> p.path("/anime-list/**").filters(f -> f.filter(authFilter().apply(new AuthFilter.Config()))).uri("lb://anime-list"))
		//.route(p -> p.path("/anime/**").uri("lb://anime"))
		.build();
	}
}