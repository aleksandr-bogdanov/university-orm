package org.abogdanov.university;

import java.sql.SQLException;
import java.util.List;

import org.abogdanov.university.domain.Dept;
import org.abogdanov.university.domain.Student;
import org.abogdanov.university.domain.Teacher;
import org.abogdanov.university.dao.Factory;


public class Main {
	public static void main(String[] args) throws SQLException {
		//Создадим двух студентов
		Student s1 = new Student();
		Student s2 = new Student();

		Teacher t1 = new Teacher();
		Teacher t2 = new Teacher();

		Dept d1 = new Dept();
		Dept d2 = new Dept();

		//Проинициализируем их
		s1.setName("Ivanov Ivan");
		s1.setAge(21);
		s2.setName("Petrova Alisa");
		s2.setAge(24);

		t1.setFirstName("Alexander");
		t1.setLastName("Makhortov");
		t2.setFirstName("Maksim");
		t2.setLastName("Shestakov");

		d1.setName("Computational Mathematics");
		d2.setName("Nonlinear Equations");


		//Сохраним их в бд, id будут сгенерированы автоматически
		Factory.getInstance().getStudentDAO().add(s1);
		Factory.getInstance().getStudentDAO().add(s2);

		Factory.getInstance().getTeacherDAO().add(t1);
		Factory.getInstance().getTeacherDAO().add(t2);

		Factory.getInstance().getDeptDAO().add(d1);
		Factory.getInstance().getDeptDAO().add(d2);

		//Выведем всех студентов из бд
		List<Student> studs = Factory.getInstance().getStudentDAO().getAll();
		System.out.println("\n\n\tВсе студенты\n=============================");
		for (int i = 0; i < studs.size(); ++i) {
			System.out.println("Фамилия-имя: " +
					studs.get(i).getName() +
					"\nВозраст : " +
					studs.get(i).getAge() +
					"\nid : " +
					studs.get(i).getId());
			System.out.println("=============================");
		}

		//Выведем всех преподавателей из бд
		List<Teacher> teachers = Factory.getInstance().getTeacherDAO().getAll();
		System.out.println("\n\n\tВсе преподаватели\n=============================");
		for (Teacher teacher : teachers) {
			System.out.println("Имя: " +
					teacher.getFirstName() +
					"\nФамилия: " +
					teacher.getLastName() +
					"\nid: " +
					teacher.getId());
			System.out.println("=============================");
		}

		//Выведем все кафедры из бд
		List<Dept> depts = Factory.getInstance().getDeptDAO().getAll();
		System.out.println("\n\n\tВсе кафедры\n=============================");
		for (Dept dept : depts) {
			System.out.println("Название: " +
					dept.getName());
			System.out.println("=============================");
		}
	}
}
