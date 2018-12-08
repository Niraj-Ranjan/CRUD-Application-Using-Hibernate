package com.niraj.operation;

import java.io.Serializable;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="student_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="student_name")
	private String studentname;
	@Column(name="roll_number")
	private int rollnumber;
	@Column(name="course")
	private String course;
	
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", studentname=" + studentname + ", rollnumber=" + rollnumber + ", course="
				+ course + "]";
	}
	
	
	
	
	
	
	

}
