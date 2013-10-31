package org.abogdanov.university.domain;

public class Exam {
	private int id;
	private Student student_id;

	public Exam() {
	}

	public Exam(Student student_id) {
		this.student_id = student_id;
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
}
