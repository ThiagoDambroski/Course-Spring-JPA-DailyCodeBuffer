package com.dambroski.springdatajpa.repository;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dambroski.springdatajpa.entity.Course;
import com.dambroski.springdatajpa.entity.Teacher;

@SpringBootTest
class TeacherRepositoryTest {
	
	@Autowired
	private TeacherRepository repository;
	
	@Test
	public void saveTeacher() {
		List<Course> courses = new ArrayList<>();
		Course course = Course.builder()
				.title("GEO")
				.credit(3)
				.build();
		
		courses.add(course);
		
		Teacher teacher = Teacher.builder()
				.firstName("thiago")
				.lastName("dambroski")
				.course(courses)
				.build();
		
		repository.save(teacher);
	}
	
	@Test
	public void getAllTeachers(){
		List<Teacher> teachers = repository.findAll();
		System.out.println(teachers);
	}

}
