package com.ferreira.employeediretory.entity;

/**
 * @author ferreira
 * @since 18/01/2020
 *
 */
public class Login {

	private long id;
	private String email;
	private String password;

	public Login(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
