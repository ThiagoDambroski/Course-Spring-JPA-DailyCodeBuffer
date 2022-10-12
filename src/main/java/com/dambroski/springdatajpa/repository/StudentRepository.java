package com.dambroski.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dambroski.springdatajpa.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
