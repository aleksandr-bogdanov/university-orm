package org.abogdanov.hibernate;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManageUniversity {
	private static SessionFactory factory;

	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		ManageUniversity MT = new ManageUniversity();

		Dept SE = MT.addDept("Software Engineering");
		Dept NO = MT.addDept("Nonlinear Oscillations");

		Integer teacherID1 = MT.addTeacher("Alexander", "Makhortov", SE);
		Integer teacherID2 = MT.addTeacher("Maksim", "Shestakov", SE);
		Integer teacherID3 = MT.addTeacher("Irina", "Kostrub", NO);
		MT.listTeachers();
//		MT.updateTeacher(teacherID1, "Sergey", "Makhortov");
//		MT.deleteTeacher(teacherID1);
//		MT.listTeachers();

		Integer studentID1 = MT.addStudent("Alexey", "Bogdanov");
		Integer studentID2 = MT.addStudent("Alexander", "Reshetnikov");
		Integer studentID3 = MT.addStudent("Konstantin", "Kostikov");
		MT.listStudents();
//		MT.updateStudent(studentID1, "Alexander", "Bogdanov");
//		MT.deleteStudent(studentID1);
//		MT.listStudents();

		Integer examID1 = MT.addExam(studentID1, teacherID1, 5);
		Integer examID2 = MT.addExam(studentID2, teacherID2, 4);
		Integer examID3 = MT.addExam(studentID3, teacherID3, 3);
		MT.listExams();
//		MT.updateExam(examID2, 5);
//		MT.deleteExam(examID3);
//		MT.listExams();


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
			System.out.println("\n\t\t--- LIST OF TEACHERS ---");
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


	/* Method to add a student record in the database */
	public Integer addStudent(String fname, String lname) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer studentID = null;
		try {
			tx = session.beginTransaction();
			Student student = new Student(fname, lname);
			studentID = (Integer) session.save(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return studentID;
	}

	/* Method to list all the students detail */
	public void listStudents() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List students = session.createQuery("FROM Student").list();
			System.out.println("\n\t\t--- LIST OF STUDENTS ---");
			for (Iterator iterator =
						 students.iterator(); iterator.hasNext(); ) {

				Student student = (Student) iterator.next();
				System.out.println("Student");
				System.out.println(" - Info: ");
				System.out.println("\tFirst Name: " + student.getFirstName());
				System.out.println("\tLast Name: " + student.getLastName());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}
	}

	/* Method to update names for a student */
	public void updateStudent(Integer StudentID, String fname, String lname) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student =
					(Student) session.get(Student.class, StudentID);
			student.setFirstName(fname);
			student.setLastName(lname);
			session.update(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to delete a student from the records */
	public void deleteStudent(Integer StudentID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Student student =
					(Student) session.get(Student.class, StudentID);
			session.delete(student);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}


	/* Method to add an exam record in the database */
	public Integer addExam(Integer TeacherID, Integer StudentID, Integer grade) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer examID = null;
		try {
			tx = session.beginTransaction();
			Exam exam = new Exam(TeacherID, StudentID, grade);
			examID = (Integer) session.save(exam);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return examID;
	}

	/* Method to list all the exams detail */
	public void listExams() {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			List students = session.createQuery("FROM Exam").list();
			System.out.println("\n\t\t--- LIST OF EXAMS ---");
			for (Iterator iterator =
						 students.iterator(); iterator.hasNext(); ) {

				Exam exam = (Exam) iterator.next();
				System.out.println("Exam");
				System.out.println(" - Info: ");
				System.out.println("\tTeacher ID: " + exam.getTeacher_id());
				System.out.println("\tStudent ID: " + exam.getStudent_id());
				System.out.println("\tGrade: " + exam.getGrade());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {

			session.close();
		}
	}

	/* Method to update IDs for exam */
	public void updateExam(Integer ExamID, Integer grade) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Exam exam =
					(Exam) session.get(Exam.class, ExamID);
			exam.setGrade(grade);
			session.update(exam);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	/* Method to delete an exam from the records */
	public void deleteExam(Integer ExamID) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Exam exam =
					(Exam) session.get(Exam.class, ExamID);
			session.delete(exam);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}