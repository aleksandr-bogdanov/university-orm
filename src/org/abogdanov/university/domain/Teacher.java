package org.abogdanov.university.domain;

public class Teacher {
	private int id;
	private String firstName;
	private String lastName;
	private Dept dept_id;

	public Teacher() {
	}

	public Teacher(String firstName, String lastName, Dept dept_id) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept_id = dept_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Dept getDept_id() {
		return dept_id;
	}

	public void setDept_id(Dept dept_id) {
		this.dept_id = dept_id;
	}
}
