package org.abogdanov.hibernate;

import java.util.*;

public class Exam {
	private int id;
	private int teacher_id;
	private int student_id;
	//TODO: Implement date feature
	//private Date date;
	private int grade;
	private List subjects;


	public Exam() {
	}

	public Exam(int teach_id, int student_id, int grade) {
		this.teacher_id = teach_id;
		this.student_id = student_id;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
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
