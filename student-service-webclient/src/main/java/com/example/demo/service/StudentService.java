package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentRequest;
import com.example.demo.dao.StudentResponses;
import com.example.demo.dao.StudentDao;
import com.example.demo.dao.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	 public StudentResponses getStudentService(StudentRequest student) {
		 StudentDao input = new StudentDao();
		 input.setName(input.getName());
		 input.setAge(input.getAge());
		StudentDao add = studentRepository.save(input);
		StudentResponses studentResponse = new StudentResponses();
		studentResponse.setName(add.getName());
		studentResponse.setAge(add.getAge());
		return studentResponse;
	}
	 
	 public StudentResponses getStudent(Long id) {
		 Optional<StudentDao> student = studentRepository.findById(id);
		 StudentResponses studentResponses = new StudentResponses();
		 studentResponses.setId(student.get().getId());
		 studentResponses.setName(student.get().getName());
		 studentResponses.setAge(student.get().getAge());
		 return studentResponses;
	 }
}
