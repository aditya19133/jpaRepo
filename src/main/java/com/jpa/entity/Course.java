package com.jpa.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseId;
	private String title;
	private int credit;
	
	@OneToOne( mappedBy = "course" )
	CourseMaterial courseMaterial;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "teacher_id", referencedColumnName = "id")
	Teacher teacher; 
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable( name = "Student_Course_Map"
				, joinColumns = @JoinColumn( name = "course_id", referencedColumnName = "courseId" )
				, inverseJoinColumns = @JoinColumn(name = "roll_no", referencedColumnName = "rollNo")
			)
	List<Student> students;
	
	public Course() {}
	
	public Course(Long courseId, String title, int credit) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.credit = credit;
	}
	
	public Course(Long courseId, String title, int credit, Teacher teacher) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.credit = credit;
		this.teacher = teacher;
	}
	
	public Course(Long courseId, String title, int credit, Teacher teacher, List<Student> students) {
		super();
		this.courseId = courseId;
		this.title = title;
		this.credit = credit;
		this.teacher = teacher;
		this.students = students;
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", title=" + title + ", credit=" + credit + ", courseMaterial="
				+ courseMaterial + "]";
	}

	public Long getCourseId() {
		return courseId;
	}
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	
	

}
