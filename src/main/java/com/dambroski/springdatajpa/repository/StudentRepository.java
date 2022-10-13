package com.dambroski.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dambroski.springdatajpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	public List<Student> findByFirstName(String firstName);
	
	public List<Student> findByFirstNameContaining(String name);
	
	public List<Student> findByLastNameNotNull();
	
	public List <Student> findByGuardianName(String name);

}
