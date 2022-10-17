package com.dambroski.springdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dambroski.springdatajpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
