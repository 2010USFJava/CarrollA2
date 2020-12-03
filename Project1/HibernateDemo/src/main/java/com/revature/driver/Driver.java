package com.revature.driver;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.Dao.StudentDao;
import com.revature.DaoImpl.StudentDaoImpl;
import com.revature.bean.Student;
import com.revature.bean.Teacher;
import com.revature.util.HibernateUtil;

public class Driver {
	
	public static void main(String[] args) {
		Teacher teach = new Teacher(0, "henry", "git", new ArrayList<Student>());
		Session s = HibernateUtil.getSession();
		Transaction tx = s.beginTransaction();
		s.save(teach);
		tx.commit();
		
		Student stu = new Student(0,"bob","greg", new ArrayList<Teacher>());
		StudentDao sdao= new StudentDaoImpl();
		sdao.insert(stu);
		
		Teacher teach2 = new Teacher(0, "sam", "jones", new ArrayList<Student>());
		s.save(teach2);
		
		stu.getTeachers().add(teach);
		stu.getTeachers().add(teach2);
		
		tx = s.beginTransaction();
		tx.commit();
		
	
		
		
	}

}
