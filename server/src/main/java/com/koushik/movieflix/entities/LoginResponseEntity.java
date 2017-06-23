package com.koushik.movieflix.entities;

public class LoginResponseEntity {

	private String email;
	private String role;
	private String firstName;
	private String lastName;
	private String userId;
	private String token;
	
	public LoginResponseEntity() {

	}
	
	
	
	public LoginResponseEntity(String email, String role, String firstName, String lastName, String userId,
			String token) {
		super();
		this.email = email;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userId;
		this.token = token;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
