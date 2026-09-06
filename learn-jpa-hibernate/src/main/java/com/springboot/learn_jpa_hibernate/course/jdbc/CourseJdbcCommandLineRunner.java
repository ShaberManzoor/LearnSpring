package com.springboot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.learn_jpa_hibernate.course.Course;
import com.springboot.learn_jpa_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repo;
	
//	@Autowired
//	private CouseJpaRepository repo;
	
	@Autowired
	private CourseSpringDataJpaRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repo.save(new Course(1, "Learn Spring", "in28mins"));
		repo.save(new Course(2, "Learn AWS", "in28mins"));
		repo.save(new Course(3, "Learn DevOps", "in28mins"));
		
		repo.deleteById(3l);
		
		System.out.println(repo.findById(1l));
		System.out.println(repo.findById(2l));
		
		System.out.println(repo.findByAuthor("in28mins"));
	}
}
