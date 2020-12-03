package com.revature.Dao;

import java.util.List;

import com.revature.bean.*;

public interface StudentDao {
	
	public List<Student> findAll();
	
	public Student findById(int id);
	
	public Student findByfirstName(String name);
	
	public Student findByLastName(String name);
	
	public List<Student> findByTeacher(Teacher teacher);
	
	public void insert(Student student);
	
	public void delete(Student student);
	
	public void update(Student student);
	
}
