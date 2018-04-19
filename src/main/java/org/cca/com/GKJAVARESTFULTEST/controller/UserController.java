package org.cca.com.GKJAVARESTFULTEST.controller;

import javax.servlet.http.HttpSession;

import org.cca.com.GKJAVARESTFULTEST.ResponseUtil.ResponseUtil;
import org.cca.com.GKJAVARESTFULTEST.domain.UserDetail;
import org.cca.com.GKJAVARESTFULTEST.dto.entity.user.UserList;
import org.cca.com.GKJAVARESTFULTEST.dto.response.AbstractResponseDto;
import org.cca.com.GKJAVARESTFULTEST.repository.UserDetailRepository;
import org.cca.com.GKJAVARESTFULTEST.service.UserManagedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
    @Autowired
    private UserDetailRepository userDetailRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserDetailRepository userDetailRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailRepository = userDetailRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PutMapping("/sign-up")
    public void signUp(@RequestBody UserDetail user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userDetailRepository.save(user);
    }
   
    UserManagedService userService;  //Service which will do all data retrieval/manipulation work here 
    @RequestMapping(value = "/count", method = RequestMethod.GET)
    public HttpEntity<AbstractResponseDto> UserDetail() {
    	
        return ResponseUtil.success().body(userService.count()).message("").send(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/all-users", method = RequestMethod.GET)
    public HttpEntity<AbstractResponseDto> listAllUsers() {
        UserList users = userService.findAllUsers();
        if(users.getUserList().isEmpty()){
            return ResponseUtil.error().message("No data found").send(HttpStatus.NOT_FOUND);
        }
        return ResponseUtil.success().body(users).message("User list fetched successfully !!!").send(HttpStatus.OK);
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void login(HttpSession session) {
        session.invalidate();
	}
    
    @RequestMapping(value = "/logout/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        session.invalidate();
	}
 
}
