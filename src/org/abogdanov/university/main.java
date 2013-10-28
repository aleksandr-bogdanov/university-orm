package org.abogdanov.university;

import java.sql.SQLException;
import java.util.List;

import org.abogdanov.university.domain.Student;
import org.abogdanov.university.dao.Factory;


public class Main {
	public static void main(String[] args) throws SQLException {
		//Создадим двух студентов
		Student s1 = new Student();
		Student s2 = new Student();

		//Проинициализируем их
		s1.setName("Ivanov Ivan");
		s1.setAge(21);
		s2.setName("Petrova Alisa");
		s2.setAge(24);

		//Сохраним их в бд, id будут сгенерированы автоматически
		Factory.getInstance().getStudentDAO().add(s1);
		Factory.getInstance().getStudentDAO().add(s2);

		//Выведем всех студентов из бд
		List<Student> studs = Factory.getInstance().getStudentDAO().getAll();
		System.out.println("========Все студенты=========");
		for (int i = 0; i < studs.size(); ++i) {
			System.out.println("Имя студента : " +
					studs.get(i).getName() +
					", Возраст : " +
					studs.get(i).getAge() +
					",  id : " +
					studs.get(i).getId());
			System.out.println("=============================");
		}
	}
}
