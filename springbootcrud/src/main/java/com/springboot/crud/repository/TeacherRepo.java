package com.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud.model.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

}
