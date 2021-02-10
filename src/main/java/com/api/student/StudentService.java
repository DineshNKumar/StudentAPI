package com.api.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {
		Optional<Student> findByEmail = studentRepository.findStudentByEmail(student.getEmail());
		if(findByEmail.isPresent()) {
			throw new IllegalStateException("Email is duplicate");
		}
		System.out.println(student);
		studentRepository.save(student);
	}

	public void deleteStudent(Integer id) {
		boolean exists = studentRepository.existsById(id);
		if(exists) {
			studentRepository.deleteById(id);
		}else {
			throw new IllegalStateException("Student is not available for this id");
		}
	}

	@Transactional
	public void updateStudent(Integer id, String name, String email) {
		Student student = studentRepository.findById(id).orElseThrow();
		if(name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		if(name != null && name.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			Optional<Student> findEmail = studentRepository.findStudentByEmail(email);
			if(findEmail.isPresent()) {
				throw new IllegalStateException("Duplicate error");
			}
			student.setEmail(email);
		}
	}
}
