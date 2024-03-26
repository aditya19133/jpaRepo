package com.jpa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.entity.Guardian;
import com.jpa.entity.Student;
import com.jpa.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	//	void saveStudent() {
	//		
	//		Student stu1 = new Student(1L,"Aditya","aditya@gmail.com");
	//		studentRepo.save(stu1);
	//	}

	void printAllStudent()
	{
		List<Student> findAll = studentRepo.findAll();
		System.out.println(findAll);

	}

//	void saveStudentWithGuardian() {
//
//		Guardian guardian1 = new Guardian("Ad","ad@gmail.com","Panna, MP");
//		Student student1 = new Student(1L,"Aditya","aditya@gmail.com",guardian1);	
//		studentRepo.save(student1);
//
//	}

	void findByName()
	{
		Student findByName = studentRepo.findByName("Aditya");
		System.out.println(findByName);	
	}

	void findStudentByEmail()
	{

		Long findStudentRollNoByEmailId = studentRepo.findStudentRollNoByEmailId("aditya@gmail.com");
		System.out.println(findStudentRollNoByEmailId);

	}
	
	

}
