package com.springboot.learn_jpa_hibernate.course.springdatajpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.learn_jpa_hibernate.course.Course;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByAuthor(String author);
	
}
