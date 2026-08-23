package com.in28min.learn_spring_boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> getAllCourses() {
        return Arrays.asList(
                new Course(1, "AWS", "Amazon"),
                new Course(2, "Azure", "Microsoft"),
                new Course(3, "GCP", "Google"),
                new Course(4, "Java", "Udemy Test")
        );
    }

}
