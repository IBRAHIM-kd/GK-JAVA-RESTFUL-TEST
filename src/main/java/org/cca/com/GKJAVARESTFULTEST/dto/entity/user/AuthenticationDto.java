package org.cca.com.GKJAVARESTFULTEST.dto.entity.user;

import org.cca.com.GKJAVARESTFULTEST.domain.UserDetail;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "phone", "username", "password" })
public class AuthenticationDto {
	
    private String phone;
	
	private String username;
	private String password;
	
	public AuthenticationDto(){}

	public String getPhone() {
		return phone;
	}

	public void setName(String phone) {
		this.phone = phone;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserDetail buildUser(){
		return new UserDetail(phone, username, password);
	}

	public UserDto detail(){
		UserDto user = new UserDto();
		user.setPhone(this.getPhone());
		return user;
	}
}
