package com.luka.anirest.model;

public class PasswordlessUser {

	private int idUser;

	private String name;

	private String surname;

	private String username;

	private String email;

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PasswordlessUser(int idUser, String name, String surname, String username, String email) {
		super();
		this.idUser = idUser;
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.email = email;
	}

}