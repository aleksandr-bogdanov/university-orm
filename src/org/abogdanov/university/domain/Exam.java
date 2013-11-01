package org.abogdanov.university.domain;

public class Exam {
	private int id;
	private Student student_id;
	private Teacher teacher;
	private Subject subject;
	private int grade;

	public Exam() {
	}

	public Exam(Student student_id, Teacher teacher, Subject subject, int grade) {
		this.student_id = student_id;
		this.teacher = teacher;
		this.subject = subject;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getStudent_id() {
		return student_id;
	}

	public void setStudent_id(Student student_id) {
		this.student_id = student_id;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
