package com.etoe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.etoe.entities.Student;
import com.etoe.repos.StudentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentdalApplicationTests {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setName("John Doe");
		student.setCourse("Java Web Services");
		student.setFee(30d);
		studentRepository.save(student);
	}
	
	@Test
	public void testfindStudentById() {
		Student student = studentRepository.findById(1l).get();
		System.out.println(student);
	}
	
	@Test
	public void testUpdateStudent() {
		Student student = studentRepository.findById(1l).get();
		student.setFee(40d);
		studentRepository.save(student);
	}
	
	@Test
	public void testdeleteStudent() {
		studentRepository.deleteById(1l);
	}
}
