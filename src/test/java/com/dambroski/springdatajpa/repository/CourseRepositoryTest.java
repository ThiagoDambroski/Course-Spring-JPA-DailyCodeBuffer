package com.dambroski.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dambroski.springdatajpa.entity.Course;
import com.dambroski.springdatajpa.entity.Teacher;

@SpringBootTest
class CourseRepositoryTest {

	@Autowired
	private CourseRepository repository;
	
	 
	@Test
	public void printCourse() {
		List<Course> courses = repository.findAll();
		System.out.println(courses);
	}
	
	
	@Test
	public void saveCourseWithTeacher() {
		Teacher teacher = Teacher.builder()
				.firstName("leticia")
				.lastName("lima")
				.build();
		
		Course course = Course.builder()
				.title("java")
				.credit(5)
				.teacher(teacher)
				.build();
		
		repository.save(course);
				
	}

}
