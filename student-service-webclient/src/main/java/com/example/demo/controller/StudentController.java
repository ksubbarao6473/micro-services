package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentRequest;
import com.example.demo.dao.StudentResponses;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
	private StudentResponses createStudent(@RequestBody StudentRequest studentRequest) {
		return studentService.getStudentService(studentRequest);
	}
	@GetMapping("/get/{id}")
	private StudentResponses getStudent(@PathVariable("id") Long id) {
		return studentService.getStudent(id);
	}
}
