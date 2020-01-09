package com.vladyslav.hibernate.demo;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.demo.entity.Student;

public class UpdateStudentDemo {
	
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
		Session session = factory.getCurrentSession();

	
		try {
			
		session.beginTransaction();
		
		List<Student> list = session.createQuery("from Student").getResultList();
		
		int id = new Random().nextInt(list.size());
		
		Student tempStudent = session.get(Student.class, id);
		
		tempStudent.setEmail("test123@gmail.com");
		
		System.out.println(tempStudent);
		
		session.getTransaction().commit();
		
		} finally {
			
		session.close();
		
		}
	}
}
