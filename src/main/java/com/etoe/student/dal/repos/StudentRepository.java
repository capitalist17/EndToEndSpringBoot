package com.etoe.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.etoe.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

}
