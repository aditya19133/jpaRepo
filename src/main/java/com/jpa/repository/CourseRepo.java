package com.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

}
