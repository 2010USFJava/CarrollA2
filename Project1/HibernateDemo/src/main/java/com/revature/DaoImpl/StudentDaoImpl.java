package com.revature.DaoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.revature.Dao.StudentDao;
import com.revature.bean.Student;
import com.revature.bean.Teacher;
import com.revature.util.HibernateUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> findAll() {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("From Student s", Student.class);
		return (List<Student>) query.getResultList();
	}

	@Override
	public Student findById(int id) {
		Session s = HibernateUtil.getSession();
		return s.get(Student.class, id);
	}

	@Override
	public Student findByfirstName(String name) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("From Student s WHERE s.firstName = :name", Student.class);
		query.setParameter("firstName", name);
		Student student  = (Student) query.getSingleResult();
		return student;
	}

	@Override
	public Student findByLastName(String name) {
		Session s = HibernateUtil.getSession();
		Query query = s.createQuery("From Student s WHERE s.lastName = :name", Student.class);
		query.setParameter("lastName", name);
		Student student  = (Student) query.getSingleResult();
		return student;
	}

	@Override
	public List<Student> findByTeacher(Teacher teacher) {
		Session s = HibernateUtil.getSession();
		
		return null;
	}

	@Override
	public void insert(Student student) {
		Session s = HibernateUtil.getSession();
		s.save(student);
	}

	@Override
	public void delete(Student student) {
		Session s = HibernateUtil.getSession();
		s.delete(student);	
	}

	@Override
	public void update(Student student) {
		Session s = HibernateUtil.getSession();
		s.save(student);
	}

}
