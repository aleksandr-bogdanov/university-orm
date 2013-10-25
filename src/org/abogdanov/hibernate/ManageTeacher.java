package org.abogdanov.hibernate;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageTeacher {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
		ManageTeacher MT = new ManageTeacher();
		Dept SE = MT.addDept("Software Engineering");
		Integer teacherID1 = MT.addTeacher("Alexander", "Makhortov", SE);
		Integer teacherID2 = MT.addTeacher("Maksim", "Shestakov", SE);
		MT.listTeachers();
		MT.updateTeacher(teacherID1, "Sergey", "Makhortov");
		MT.deleteTeacher(teacherID1);
		MT.listTeachers();
	}

	/* Method to add an department record in the database */
	public Dept addDept(String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer deptID = null;
		Dept dept = null;
		try {
			tx = session.beginTransaction();
			dept = new Dept(name);
			deptID = (Integer) session.save(dept);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return dept;
	}

	/* Method to add a teacher record in the database */
	public Integer addTeacher(String fname, String lname, Dept dept) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer teacherID = null;
		try {
			tx = session.beginTransaction();
			Teacher teacher = new Teacher(fname, lname, dept);
			teacherID = (Integer) session.save(teacher);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return teacherID;
	}

	/* Method to list all the teachers detail */
	public void listTeachers() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List teachers = session.createQuery("FROM Teacher").list();
			System.out.println("\t\t--- LIST OF TEACHERS ---");
			for (Iterator iterator =
						 teachers.iterator(); iterator.hasNext(); ) {

				Teacher teacher = (Teacher) iterator.next();
				System.out.println("Teacher");
				System.out.println(" - Info: ");
				System.out.println("\tFirst Name: " + teacher.getFirstName());
				System.out.println("\tLast Name: " + teacher.getLastName());

				Dept dept = teacher.getDept();
				System.out.println(" - Dept: ");
				System.out.println("\tName: " + dept.getName());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}
	}

	/* Method to update names for a teacher */
	public void updateTeacher(Integer TeacherID, String fname, String lname) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Teacher teacher =
					(Teacher) session.get(Teacher.class, TeacherID);
			teacher.setFirstName(fname);
			teacher.setLastName(lname);
			session.update(teacher);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to delete a teacher from the records */
	public void deleteTeacher(Integer TeacherID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Teacher teacher =
					(Teacher) session.get(Teacher.class, TeacherID);
			session.delete(teacher);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}