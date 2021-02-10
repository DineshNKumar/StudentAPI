package com.api.student;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;
import javax.persistence.GenerationType;

@Entity
@Table
public class Student {
	
	@Id
	@SequenceGenerator(
			name="sequence_stu",
			sequenceName = "sequence_stu",
			allocationSize = 1
			)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_stu")
	private Integer id;
	private String name;
	private LocalDate date;
	private String course;
	private String email;
	
	@Transient
	private Integer age;
	
	public Student() {}
	
	public Student(Integer id, String name, LocalDate date, String course, String email) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.course = course;
		this.email = email;
	}

	public Student(String name, LocalDate date, String course, String email) {
		super();
		this.name = name;
		this.date = date;
		this.course = course;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return Period.between(this.date, LocalDate.now()).getYears();
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", date=" + date + ", course=" + course + ", email=" + email
				+ "]";
	}

}
