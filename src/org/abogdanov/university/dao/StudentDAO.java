package org.abogdanov.university.dao;

import org.abogdanov.university.domain.Student;

import java.util.List;
import java.sql.SQLException;

public interface StudentDAO {

	public void add(Student student) throws SQLException;        //добавить студента

	public void update(Student student) throws SQLException;    //обновить студента

	public Student getById(Long id) throws SQLException;        //получить студента по id

	public List<Student> getAll() throws SQLException;            //получить всех студентов

	public void delete(Student student) throws SQLException;    //удалить студента

}
