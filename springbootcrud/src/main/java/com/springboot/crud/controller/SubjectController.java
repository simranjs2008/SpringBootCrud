package com.springboot.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.crud.model.Student;
import com.springboot.crud.model.Subject;
import com.springboot.crud.model.Teacher;
import com.springboot.crud.repository.StudentRepo;
import com.springboot.crud.repository.SubjectRepo;
import com.springboot.crud.repository.TeacherRepo;

@RestController
public class SubjectController {

	@Autowired
	SubjectRepo subjectRepo;
	
	@Autowired
	TeacherRepo teacherRepo;
	
	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping("/subject/{id}")
	public Subject getSubjectbyId(@PathVariable("id") int id) {
		Subject subject = subjectRepo.findById(id).get();
		return subject;
	}
	
	@GetMapping("/subjects")
	public List<Subject> getSubject() {
		List<Subject> subjectsList = subjectRepo.findAll();
		return subjectsList;
	}
	
	@PostMapping("/addSubject")
	public Subject addSubject(@RequestBody Subject subject) {
		System.out.println(subject);
		Subject addedSubject = subjectRepo.save(subject);
		return addedSubject;
	}
	
	@DeleteMapping("/deleteSubject/{id}")
	public void deleteSubjectbyId(@PathVariable("id") int id) {
		subjectRepo.deleteById(id);
	}
	
	@PutMapping("/subject/{subjectId}/teacher/{teacherId}")
	public Subject assignTeacher(@PathVariable("subjectId") int subjectId, @PathVariable("teacherId") int teacherId) {
		Subject subject = subjectRepo.findById(subjectId).get();
		Teacher teacher = teacherRepo.findById(teacherId).get();
		if( teacher==null) {
			return null;
		}
		subject.setTeacher(teacher);
		Subject addedSubject = subjectRepo.save(subject);
		return addedSubject;
	}
	
	@PutMapping("/subject/{subjectId}/student/{studentId}")
	public Subject assignStudent(@PathVariable("subjectId") int subjectId, @PathVariable("studentId") int studentId) {
		Subject subject = subjectRepo.findById(subjectId).get();
		Student student = studentRepo.findById(studentId).get();
		if( student==null) {
			return null;
		}
		subject.addStudent(student);
		Subject addedSubject = subjectRepo.save(subject);
		return addedSubject;
	}
}
