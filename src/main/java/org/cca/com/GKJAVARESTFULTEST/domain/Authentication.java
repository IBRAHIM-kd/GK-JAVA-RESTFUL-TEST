package org.cca.com.GKJAVARESTFULTEST.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Authentication {

	@Id
	private String username;
	private String password;
	
	public Authentication(){}
	
	public Authentication(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
}
