package com.springboot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springJdbcTemplate;
	
	private static String INSERT_QUERY = 
			"""
				INSERT INTO COURSE
				VALUES (2, 'Learn AWS', 'in28mins');
			""";
	
	public void insert() {
		springJdbcTemplate.update(INSERT_QUERY);
	}
}
