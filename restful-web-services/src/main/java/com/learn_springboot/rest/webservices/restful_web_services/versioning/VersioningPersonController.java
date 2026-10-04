package com.learn_springboot.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	// /person?version=1
	@GetMapping(path="/person", params="version=1")
	public PersonV1 getFirstVersionOfPersonRequestParams() {
		return new PersonV1("Bob Charlie");
	}
	
	// /person?version=2
	@GetMapping(path="/person", params="version=2")
	public PersonV2 getSecondVersionOfPersonRequestParams() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}

	@GetMapping(path="/person/header", headers="X-API-VERSION=1")
	public PersonV1 getFirstVersionOfPersonRequestHeaders() {
		return new PersonV1("Bob Charlie");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public PersonV2 getSecondVersionOfPersonRequestHeaders() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
}
