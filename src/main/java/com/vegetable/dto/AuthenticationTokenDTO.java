package com.vegetable.dto;

public class AuthenticationTokenDTO {

	private String token;

	public AuthenticationTokenDTO() {
		super();
	}

	public AuthenticationTokenDTO(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "AuthenticationTokenDTO [token=" + token + "]";
	}

}
