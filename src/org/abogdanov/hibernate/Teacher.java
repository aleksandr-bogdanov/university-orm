package org.abogdanov.hibernate;

public class Teacher {
	private int id;
	private String firstName;
	private String lastName;
	private Dept dept;

	public Teacher() {
	}

	public Teacher(String firstName, String lastName, Dept dept) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dept = dept;
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

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}
}
