package com.learn_springboot.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
//import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	private static Integer userCount = 0;
	
	static {
		users.add(new User(++userCount, "Ram", LocalDate.now().minusYears(30)));
		users.add(new User(++userCount, "Raj", LocalDate.now().minusYears(10)));
		users.add(new User(++userCount, "Rit", LocalDate.now().minusYears(15)));
	}
	
	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findUser(int id) {
//		Predicate<? super User> predicate = user -> user.getId().equals(id);
//		return users.stream().filter(predicate).findFirst().get();
		
		User user = null;
		for(User u: users) {
			if(u.getId().equals(id)) {
				user = u;
				break;
			}
		}
		
		return user;
	}
}
