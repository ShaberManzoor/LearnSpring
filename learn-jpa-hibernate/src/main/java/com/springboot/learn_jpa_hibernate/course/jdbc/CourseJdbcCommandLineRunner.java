package com.springboot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.insert();
	}
	
}
