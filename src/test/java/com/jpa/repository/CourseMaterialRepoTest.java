package com.jpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jpa.entity.Course;
import com.jpa.entity.CourseMaterial;

@SpringBootTest
class CourseMaterialRepoTest {

	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	CourseMaterialRepo courseMaterialRepo;
	
	@Test
	void saveCourseMaterial() {
		
		Course course = new Course(1L, "DS", 3);
		CourseMaterial courseMaterial = new CourseMaterial(1L,"www.ds.com", course);
		
		courseMaterialRepo.save(courseMaterial);
		
	}
	
	@Test
	void fetchCourseMaterialOnly()   //Lazy fetch type testing
	{
		
		 List<CourseMaterial> findAll = courseMaterialRepo.findAll();
		System.out.println(findAll);
	}

}
