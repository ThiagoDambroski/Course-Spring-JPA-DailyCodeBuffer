package com.dambroski.springdatajpa.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dambroski.springdatajpa.entity.Course;
import com.dambroski.springdatajpa.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepositoryTest {
	
	@Autowired
	private CourseMaterialRepository repository;
	
	@Test
	public void saveCourseMaterial() {
		Course course = Course.builder()
				.title("Mat")
				.credit(6)
				.build();
		
		
		CourseMaterial courseMaterial = CourseMaterial.builder()
				.url("www.google.com")
				.course(course)
				.build();
		repository.save(courseMaterial);
	}
	
}
