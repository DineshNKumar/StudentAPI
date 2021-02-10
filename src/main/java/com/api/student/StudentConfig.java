package com.api.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandRunner(StudentRepository repository) {
		return args -> {
			Student dinesh = new Student(1,"Dinesh Kumar", LocalDate.of(1998, Month.OCTOBER, 26), "MCA", "dinesh@gmail.com");
			Student deepak = new Student(2,"Deepak Kumar", LocalDate.of(1992, Month.OCTOBER, 06), "CA", "deepak.kumar@gmail.com");
			Student mohan = new Student(3,"Mohan singh", LocalDate.of(1990, Month.AUGUST, 16), "MCA", "mohansingh@gmail.com");
	
			repository.saveAll(List.of(dinesh, deepak, mohan));
			
		};
	}
}
