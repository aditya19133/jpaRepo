package com.jpa.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpa.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{
	
	Student findByName(String name);
	
	@Query("select s from Student s where s.emailId is ?1")
	Student findStudentByEmailId(String emailId);
	
	//Custom JPQL Query
	@Query("select s.rollNo from Student s where s.emailId is ?1")
	Long findStudentRollNoByEmailId(String emailId);
	
	//Native Query
	@Query(value = "SELECT * FROM STUDENT_TABLE s WHERE s.EMAIL_ID = ?1" , nativeQuery = true)
	Student findStudentRollNoByEmailIdNative(String emailId);

	//Named Parameter Query
	@Query(value = "SELECT * FROM STUDENT_TABLE s WHERE s.EMAIL_ID = :emailId", nativeQuery = true)
	Student findStudentRollNoByEmailNamedParam(@Param("emailId") String emailId );
	
	//Transactional and Modifying
	@Modifying
	@Transactional
	@Query(value = "UPDATE STUDENT_TABLE SET fullname = :name WHERE EMAIL_ID = :emailId", nativeQuery = true)
	int updateStudentNameByEmail(@Param("name") String name,@Param("emailId") String emailId);
	
//	@Modifying
//    @Transactional
//    @Query(
//	UPDATE student_table.STUDENT_TABLE SET fullname = 'Aditya' WHERE EMAIL_ID = 'aditya@gmail.com'
//            value = "update tbl_student set first_name = ?1 where email_address = ?2",
//            nativeQuery = true
//    )
//    int updateStudentNameByEmailId(String firstName, String emailId);
}
