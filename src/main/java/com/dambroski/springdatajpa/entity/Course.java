package com.dambroski.springdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "tbl_corse",uniqueConstraints = @UniqueConstraint(
		name = "title_unique",
		columnNames = "title"))
public class Course {
	
	@Id
	@SequenceGenerator(name = "course_sequence",sequenceName = "course_sequence",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
	private Long courseId;
	@Column(name = "title",nullable = false)
	private String title;
	private Integer credit;

}