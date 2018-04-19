package org.cca.com.GKJAVARESTFULTEST.dto.entity.user;

import org.cca.com.GKJAVARESTFULTEST.domain.UserDetail;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "phone" })
public class UserDto {

	@JsonIgnore
	private long id;
	
    private String phone;

	public UserDto(){}
	
	public UserDto(UserDetail user){
		this.phone = user.getPhone();
		this.id = user.getId();
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

	public UserDetail buildUser(){
		return new UserDetail();
	}
	
}
