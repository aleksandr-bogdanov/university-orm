package org.abogdanov.hibernate;

public class Dept {
	private int id;
	private String name;

	public Dept() {
	}

	public Dept(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
