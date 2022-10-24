package com.springBoot.restClient.dto;

import java.io.Serializable;

public class UserDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String login;
	private String password;
	private String UserType;
	
	public UserDTO() {
		super();
	}

	public UserDTO(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}

	public UserDTO(String login, String password, String userType) {
		super();
		this.login = login;
		this.password = password;
		UserType = userType;
	}

	public UserDTO(Long id, String login) {
		super();
		this.id = id;
		this.login = login;
	}

	public UserDTO(Long id, String login, String password, String userType) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		UserType = userType;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return UserType;
	}

	public void setUserType(String userType) {
		UserType = userType;
	}

	@Override
	public String toString() {
		return String.format("[id=%s, mail=%s, userType=%s]", id,login,UserType);
	}

	

}
