package org.abogdanov.university.dao;

import org.abogdanov.university.dao.impl.StudentDAOImpl;
import org.abogdanov.university.dao.impl.TeacherDAOImpl;
import org.abogdanov.university.dao.impl.DeptDAOImpl;

public class Factory {

	//Todo: refactor repeating code
	private static StudentDAO studentDAO = null;
	private static TeacherDAO teacherDAO = null;
	private static DeptDAO deptDAO = null;

	private static Factory instance = null;

	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public StudentDAO getStudentDAO() {
		if (studentDAO == null) {
			studentDAO = new StudentDAOImpl();
		}
		return studentDAO;
	}

	public TeacherDAO getTeacherDAO() {
		if (teacherDAO == null) {
			teacherDAO = new TeacherDAOImpl();
		}
		return teacherDAO;
	}

	public DeptDAO getDeptDAO() {
		if (deptDAO == null) {
			deptDAO = new DeptDAOImpl();
		}
		return deptDAO;
	}

}
