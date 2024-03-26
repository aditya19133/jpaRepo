package com.jpa.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.Guardian;
import com.jpa.entity.Student;

@SpringBootTest
class StudentRepoTest {

	@Autowired
	StudentRepo studentRepo;
	
//	@Test
//	void saveStudentWithGuardian() {
//		
//		Guardian guardian1 = new Guardian("Ad","ad@gmail.com","Panna, MP");
//		Student student1 = new Student(1L,"Aditya","aditya@gmail.com",guardian1);	
//		studentRepo.save(student1);
//
//	}
	
	@Test
	void printAllStudent()
	{
		List<Student> findAll = studentRepo.findAll();
		System.out.println(findAll);
		
	}
	
	@Test
	void findByName()
	{
		
		System.out.println(studentRepo.findByName("Aditya"));
		
	}
	
	@Test
	void findStudentByEmail()
	{
		
		System.out.println(studentRepo.findStudentRollNoByEmailIdNative("aditya@gmail.com"));
		
	}
	
	@Test
	void findStudentByEmailNamedParam()
	{
		
		System.out.println(studentRepo.findStudentRollNoByEmailNamedParam("aditya@gmail.com"));
		
	}
	
	@Test
	void updateStudentNameByEmail()
	{
		
		System.out.println(studentRepo.updateStudentNameByEmail("Ady", "aditya@gmail.com"));   
		
	}
	
}
