package com.ubs.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.ubs.demo.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}