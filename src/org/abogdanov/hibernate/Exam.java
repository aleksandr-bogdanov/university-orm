package org.abogdanov.hibernate;

import org.abogdanov.university.domain.Student;

import java.util.*;

public class Exam {
	private Integer id;
	private Teacher teacher_id;
	private Student student_id;
	private int grade;
	private List subjects;


	public Exam() {
	}

	public Exam(Teacher teacher_id, Student student_id, int grade) {
		this.teacher_id = teacher_id;
		this.student_id = student_id;
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Teacher getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(Teacher teacher_id) {
		this.teacher_id = teacher_id;
	}

	public Student getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Student student_id) {
		this.student_id = student_id;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public List getSubjects() {
		return subjects;
	}

	public void setSubjects(List subjects) {
		this.subjects = subjects;
	}
}
