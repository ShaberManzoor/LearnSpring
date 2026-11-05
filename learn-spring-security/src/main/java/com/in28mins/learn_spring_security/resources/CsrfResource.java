package com.in28mins.learn_spring_security.resources;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class CsrfResource {
	
	@GetMapping("/csrf-token")
	public CsrfToken retrieveCsrf(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
}
