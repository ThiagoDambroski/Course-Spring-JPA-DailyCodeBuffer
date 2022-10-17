package com.dambroski.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dambroski.springdatajpa.entity.Course;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository repository;
	
	 
	@Test
	public void printCourse() {
		List<Course> courses = repository.findAll();
		System.out.println(courses);
	}

}
