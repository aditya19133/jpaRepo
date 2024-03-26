package com.jpa.entity;



import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.jpa.repository.CourseRepo;

@SpringBootTest
class CourseTest {

	@Autowired
	CourseRepo courseRepo;
	
	@Test
	void printAllCourses() {
		 System.out.println(courseRepo.findAll());
	}
	
	@Test
	void saveCourseWithTeacher() {
		
		Teacher teacher1 = new Teacher(5L, "Mayurika","Sharma");
		
		Course course1 = new Course(5L,"DLD",7,teacher1);
		
		courseRepo.save(course1);

	}
	
	@Test
	void fetchRecordsPagable()
	{
		Pageable firstPageWithThreeRecords = PageRequest.of(0,3); //Page No - 0(1st Page), 3 records  
		Pageable secondPageWithTwoRecords = PageRequest.of(1, 2);
		
		System.out.println(courseRepo.findAll(firstPageWithThreeRecords).getContent()); 
		System.out.println(courseRepo.findAll(firstPageWithThreeRecords).getTotalElements());   //total 5 in the DB
		System.out.println(courseRepo.findAll(firstPageWithThreeRecords).getTotalPages());      //3 records per page, 2 pages should be returned
		
		System.out.println(courseRepo.findAll(secondPageWithTwoRecords).getContent());
		System.out.println(courseRepo.findAll(secondPageWithTwoRecords).getTotalElements());    //total 5 in the DB
		System.out.println(courseRepo.findAll(secondPageWithTwoRecords).getTotalPages());		//2 records per page, 3 pages should be returned
	}

	@Test
	void saveCourseWithStudent()   //Many To Many Mapping  
	{
		//Long courseId, String title, int credit, Teacher teacher, List<Student> students
		
		Teacher teacher1 = new Teacher(8,"Robert","Drowney");
		
		List<Student> students = List.of(new Student(1L,"Aditya","Kumar"));
		
		Course course1  = new Course(8L, "Sherlock Holmes", 12, teacher1, students );
		
		System.out.println(courseRepo.save(course1)); 
		
	}
	
	
}
