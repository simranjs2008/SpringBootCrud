package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.model.Teacher;
import com.springboot.crud.repository.TeacherRepo;

@RestController
public class TeacherController {

	@Autowired
	TeacherRepo teacherRepo;
	
	@GetMapping("/teacher/{id}")
	public Teacher getTeacherbyId(@PathVariable("id") int id) {
		Teacher teacher = teacherRepo.findById(id).get();
		return teacher;
	}
	
	@GetMapping("/teachers")
	public List<Teacher> getTeacher() {
		List<Teacher> teachersList = teacherRepo.findAll();
		return teachersList;
	}
	
	@PostMapping("/addTeacher")
	public Teacher Teacher(@RequestBody Teacher teacher) {
		Teacher addedTeacher = teacherRepo.save(teacher);
		return addedTeacher;
	}
	
	@DeleteMapping("/deleteTeacher/{id}")
	public void deleteTeacherbyId(@PathVariable("id") int id) {
		teacherRepo.deleteById(id);
	}
}
