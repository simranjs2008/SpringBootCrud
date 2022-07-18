package com.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
