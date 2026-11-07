package com.in28mins.learn_spring_security.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthSecurityConfiguration {

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		// making every request authenticated
		http.authorizeHttpRequests(auth -> {
			auth.anyRequest().authenticated();
		});
		
		// disable session creation
		http.sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	@Bean 
	public UserDetailsService userDetailService() {
		var user = User.withUsername("user")
				.password("{noop}password")
				.roles("USER")
				.build();
		
		var admin = User.withUsername("admin")
				.password("{noop}password")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
}
