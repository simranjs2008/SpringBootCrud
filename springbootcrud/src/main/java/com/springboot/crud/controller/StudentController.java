package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.model.Student;
import com.springboot.crud.repository.StudentRepo;

@RestController
public class StudentController {

	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping("/student/{id}")
	public Student getStudentbyId(@PathVariable("id") int id) {
		Student student = studentRepo.findById(id).get();
		return student;
	}
	
	@GetMapping("/students")
	public List<Student> getStudent() {
		List<Student> studentsList = studentRepo.findAll();
		return studentsList;
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		Student addedStudent = studentRepo.save(student);
		return addedStudent;
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudentbyId(@PathVariable("id") int id) {
		studentRepo.deleteById(id);
	}
}
