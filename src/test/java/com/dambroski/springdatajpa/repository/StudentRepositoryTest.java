package com.dambroski.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dambroski.springdatajpa.entity.Guardian;
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
				//.guardianName("jaqueline")
				//.guardianEmail("jaque@gmail.com")
				//.guardianMobile("999999999")
				.build();
		
		repository.save(student);
	}
	
	@Test
	public void SaveStudentWhitGuardian() {
		Guardian guardian = Guardian.builder()
				.email("lu@gmail.com")
				.name("luciana")
				.mobile("898798763324")
				.build();
		
		Student student = Student.builder()
				.emailId("thiago@gmail.com")
				.firstName("thiago")
				.lastName("dambroski")
				.guardian(guardian)
				.build();
		
		repository.save(student);
	}
	
	@Test
	public void printAllStudents() {
		List<Student> studentList = repository.findAll();
		System.out.println("studentList = " + studentList);
	}
	
	@Test
	public void printStudentByFirstName() {
		List<Student> students = repository.findByFirstName("leticia");
		System.out.println("students = " + students);
	}
	
	@Test
	public void printStudentByFirstNameContaining() {
		List<Student> students = repository.findByFirstNameContaining("let");
		System.out.println("students = " + students);
	}
	
	@Test
	public void printStudentsThatLastNameAreNotNull() {
		List<Student> students = repository.findByLastNameNotNull();
		System.out.println("students = " + students);
	}
	
	@Test
	public void printStudentsByGuardianName() {
		List<Student> students = repository.findByGuardianName("luciana");
		System.out.println("students = " + students);
	}
	
	@Test
	public void printStudentByEmailAdress() {
		Student student = repository.getStudentByEmailAddress("leticia@gmail.com");
		System.out.println("student = " + student);
	}
	
	@Test
	public void printStudentFirstNameByEmailAdrress() {
		String student = repository.getStudentFirstNameByEmailAddress("leticia@gmail.com");
		System.out.println(student);
	}
	
	@Test
	public void printStudentByEmailAdressNative() {
		Student student = repository.getStudentByEmailAddressNative("leticia@gmail.com");
		System.out.println("student = " + student);
	}
	
	@Test
	public void printStudentByEmailAdressNativeNamedParam() {
		Student student = repository.getStudentByEmailAddressNativeNamedParam("leticia@gmail.com");
		System.out.println("student = " + student );
	}
	
	@Test
	public void modifyingTheStudentNameByEmailId() {
		repository.updateStudentNameByEmailId("Thiago", "thiago@gmail.com");
		Student student = repository.getStudentByEmailAddress("thiago@gmail.com");
		System.out.println("student = " + student);
	}
	
}
