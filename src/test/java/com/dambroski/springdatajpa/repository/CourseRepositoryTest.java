package com.dambroski.springdatajpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.dambroski.springdatajpa.entity.Course;
import com.dambroski.springdatajpa.entity.Student;
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
	
	@Test
	public void findAllPagination() {
		Pageable firstPageWithThereeRecords =  PageRequest.of(0, 3);
		
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
		
		List<Course> courses = repository.findAll(firstPageWithThereeRecords).getContent();
		
		long totalElements = repository.findAll(firstPageWithThereeRecords).getTotalElements();
		
		long totalPages = repository.findAll(firstPageWithThereeRecords).getTotalPages();
		
		System.out.println("courses = " + courses);
		System.out.println(totalElements);
		System.out.println(totalPages);
	}
	
	@Test
	public void findAllSorting() {
		Pageable sortByTitle = PageRequest.of(0, 2,org.springframework.data.domain.Sort.by("title"));
		
		Pageable sortByCreditsDesc = PageRequest.of(0, 2,org.springframework.data.domain.Sort.by("credit")
				.descending());
		
		Pageable sortByCreditAndTitleDesc = PageRequest.of(0, 2,org.springframework.data.domain.Sort.by("title")
				.descending().and(org.springframework.data.domain.Sort.by("credit")));
		
		List<Course> courses = repository.findAll(sortByTitle).getContent();
		List<Course> coursesDesc = repository.findAll(sortByCreditsDesc).getContent();
		List<Course> coursesCreditAndTitleDesc = repository.findAll(sortByCreditAndTitleDesc).getContent();
		
		System.out.println(courses);
		System.out.println(coursesDesc);
		System.out.println(coursesCreditAndTitleDesc);
	}
	
	@Test
	public void printFindByTitleContaining() {
		Pageable firstPageTenRecords = PageRequest.of(0, 10);
		
		List<Course> courses = repository.findByTitleContaining("M", firstPageTenRecords).getContent();
		System.out.println(courses);
	}
	
	@Test
	public void saveCourseWithStudent() {
		Student student = Student.builder()
				.emailId("thiagoleticia@gmail.com")
				.firstName("thiago")
				.lastName("leticia")
				.build();
		Course course = Course.builder()
				.title("Phyton")
				.credit(5)
				.build();
		course.addStudents(student);
		repository.save(course);
	}

}
