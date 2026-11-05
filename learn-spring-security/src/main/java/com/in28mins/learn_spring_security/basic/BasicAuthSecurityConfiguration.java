package com.in28mins.learn_spring_security.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

public class BasicAuthSecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		// making every request authenticated
		http.authorizeHttpRequests(auth -> {
			auth.anyRequest().authenticated();
		});
		
		// disable session creation
		http.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.httpBasic(null);
		return http.build();
	}
}
