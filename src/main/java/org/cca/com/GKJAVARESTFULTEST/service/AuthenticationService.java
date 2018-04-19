package org.cca.com.GKJAVARESTFULTEST.service;

import java.util.HashSet;

import org.cca.com.GKJAVARESTFULTEST.domain.UserDetail;
import org.cca.com.GKJAVARESTFULTEST.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.User;

@Component
public class AuthenticationService implements UserDetailsService {


	@Autowired
    private UserDetailRepository userRepository;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
        	if(username == null ||  username.isEmpty()){
        		throw new UsernameNotFoundException("User not found");
        	}
            UserDetail user = userRepository.findByUsername(username);
            if (user == null || user.getAuthentication() == null) {
            	throw new UsernameNotFoundException("User not found");
            }
            return new User(user.getAuthentication().getUsername(), user.getAuthentication().getPassword(), new HashSet<GrantedAuthority>());
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found");
        }
    }
}
