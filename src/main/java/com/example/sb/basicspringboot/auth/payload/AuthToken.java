package com.example.sb.basicspringboot.auth.payload;

public class AuthToken {

    private String token;
    private String username;
	public AuthToken(String token) {
		this.token = token;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
    
    

}
