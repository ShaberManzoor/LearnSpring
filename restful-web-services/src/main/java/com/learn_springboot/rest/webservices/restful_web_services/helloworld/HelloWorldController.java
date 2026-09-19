package com.learn_springboot.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//REST APIs

@RestController
public class HelloWorldController {
	
//	@RequestMapping(method=RequestMethod.GET, path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "HELLO WORLD";
	}
}
