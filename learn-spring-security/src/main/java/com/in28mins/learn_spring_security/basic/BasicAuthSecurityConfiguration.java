
package com.in28mins.learn_spring_security.basic;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BasicAuthSecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/h2-console/**").permitAll()
            .anyRequest().authenticated()
        );

        // Disable CSRF for H2 console
        http.csrf(csrf -> csrf
            .ignoringRequestMatchers("/h2-console/**")
        );

        // Allow H2 console frames
        http.headers(headers -> headers
            .frameOptions(frame -> frame.sameOrigin())
        );

        // Stateless session
        http.sessionManagement(session ->
            session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        http.httpBasic(Customizer.withDefaults());

        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailService() {
//
//        var user = User.withUsername("user")
//            .password("{noop}password")
//            .roles("USER")
//            .build();
//
//        var admin = User.withUsername("admin")
//            .password("{noop}password")
//            .roles("ADMIN")
//            .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
    
    @Bean
    public DataSource dataSource() {
    	return new EmbeddedDatabaseBuilder()
    			.setType(EmbeddedDatabaseType.H2)
    			.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
    			.build();
    }
    
    @Bean
    public UserDetailsService userDetailService(DataSource dataSource) {

        var user = User.withUsername("user")
            .password("{noop}password")
            .roles("USER")
            .build();

        var admin = User.withUsername("admin")
            .password("{noop}password")
            .roles("ADMIN", "USER")
            .build();
        
        var jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(admin);

        return jdbcUserDetailsManager;
    }
}
