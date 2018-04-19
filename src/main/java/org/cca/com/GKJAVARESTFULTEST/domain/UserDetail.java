package org.cca.com.GKJAVARESTFULTEST.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String username;
    private String phone;
    private String password;
	

	@OneToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "user_authentication_id")
	private Authentication authentication;

	
	
	public UserDetail(){}
	
	public UserDetail(Long id, String phone, String username, String password) {
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.password = password;
	}

	public UserDetail(String phone,String username, String password) {
		this.phone = phone;
		this.username = username;
		this.authentication = new Authentication(username, password);
	}

	public long getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
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
	

	public Authentication getAuthentication() {
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		this.authentication = authentication;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", phone=" + phone + "]";
	}

	
}
