package com.springboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crud.model.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
