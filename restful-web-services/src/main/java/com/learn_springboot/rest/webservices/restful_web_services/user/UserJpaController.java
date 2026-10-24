package com.learn_springboot.rest.webservices.restful_web_services.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.learn_springboot.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaController {
	
	private UserRepository repo;
	
	public UserJpaController(UserRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping(path="/jpa/users")
	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	@GetMapping(path="/jpa/users/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		Optional<User> user = repo.findById(id);
		
		if(user==null) throw new UserNotFoundException("id: " + id);
		
	    EntityModel<User> entityModel =
	            EntityModel.of(user.get());
	    
	    WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
	    entityModel.add(link.withRel("all-users"));
	    
	    return entityModel;
	}
	
	@DeleteMapping(path="/jpa/users/{id}")
	public void deleteUserById(@PathVariable int id) {
		repo.deleteById(id);
	}
	
	@PostMapping(path="/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = repo.save(user); 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
