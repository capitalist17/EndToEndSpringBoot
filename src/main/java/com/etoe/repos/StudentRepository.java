package com.etoe.repos;

import org.springframework.data.repository.CrudRepository;

import com.etoe.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

}
