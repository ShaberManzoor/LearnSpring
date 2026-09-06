package com.springboot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.learn_jpa_hibernate.course.Course;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

	@Autowired
	private CourseJdbcRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.insert(new Course(1, "Learn Spring", "in28mins"));
		repo.insert(new Course(2, "Learn AWS", "in28mins"));
		repo.insert(new Course(3, "Learn DevOps", "in28mins"));
		
		repo.deleteById(3);
		
		System.out.println(repo.selectById(1));
		System.out.println(repo.selectById(2));
	}
}
