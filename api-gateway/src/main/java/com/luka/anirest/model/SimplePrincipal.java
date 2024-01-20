package com.luka.anirest.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SimplePrincipal {
	private final int id;
	private final String username;
}