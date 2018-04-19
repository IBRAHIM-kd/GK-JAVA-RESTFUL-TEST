package org.cca.com.GKJAVARESTFULTEST.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.cca.com.GKJAVARESTFULTEST.domain.UserDetail;
import org.cca.com.GKJAVARESTFULTEST.dto.entity.user.AuthenticationDto;
import org.cca.com.GKJAVARESTFULTEST.dto.entity.user.UserDto;
import org.cca.com.GKJAVARESTFULTEST.dto.entity.user.UserList;
import org.cca.com.GKJAVARESTFULTEST.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagedService {
	@Autowired
	private UserDetailRepository userRepository;

	public long count() {
		return userRepository.count();
	}
	
	public UserList findAllUsers() {
		Iterable<UserDetail> users = userRepository.findAll();
		
		if(users == null){
			return new UserList();
		}
		
		List<UserDto> dtos = new ArrayList<UserDto>();
		for (UserDetail user : users) {
			dtos.add(new UserDto(user));
		}
		return new UserList(dtos);
	}

	public UserDto findById(long id) {
		Optional<UserDetail> user = userRepository.findById(id);
		UserDto userDto = null;
		if(user != null){
			userDto = new UserDto();
		}
		return userDto;
	}

	public void saveUser(AuthenticationDto userDto) {
		userRepository.save(userDto.buildUser());
	}

	public void deleteUserById(long id) {
		userRepository.deleteById(id);
	}

}

