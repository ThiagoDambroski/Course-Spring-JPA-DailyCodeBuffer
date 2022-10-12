package com.dambroski.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dambroski.springdatajpa.entity.Student;

@SpringBootTest
//@DataJpaTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository repository;
	
	@Test
	public void saveStudent() {
		Student student = Student.builder().emailId("leticia@gmail.com")
				.firstName("leticia")
				.lastName("lima")
				.guardianName("jaqueline")
				.guardianEmail("jaque@gmail.com")
				.guardianMobile("999999999")
				.build();
		
		repository.save(student);
	}
	
	@Test
	public void printAllStudents() {
		List<Student> studentList = repository.findAll();
		System.out.println("studentList = " + studentList);
	}

}
