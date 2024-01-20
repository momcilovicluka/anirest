package com.luka.anirest.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class UserPrincipalAuthenticationToken extends AbstractAuthenticationToken {

	private static final long serialVersionUID = -7612267419343628486L;

	private final UserPrincipal principal;

	public UserPrincipalAuthenticationToken(UserPrincipal principal) {
		super(principal.getAuthorities());
		this.principal = principal;
		setAuthenticated(true);
	}

	@Override
	public Object getCredentials() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPrincipal getPrincipal() {
		return principal;
	}

}