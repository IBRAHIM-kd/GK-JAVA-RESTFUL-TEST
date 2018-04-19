package org.cca.com.GKJAVARESTFULTEST;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SuppressWarnings("unused")
@SpringBootApplication
public class GkJavaRestfulTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GkJavaRestfulTestApplication.class, args);
	}
	
	 @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
}

