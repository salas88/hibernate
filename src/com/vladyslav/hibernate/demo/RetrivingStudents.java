package com.vladyslav.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.demo.entity.Student;

public class RetrivingStudents {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();
	
	try {
	
		session.beginTransaction();
		
		// query Students 
		List<Student> list = session.createQuery("from Student").list();
		
		// display Students
		list.forEach(lists -> System.out.println(lists));
		
		// query Students 
		List<Student> list2 = session.createQuery("from Student s where s.firstName='Vlad'").list();
		
		// display Students
		list2.forEach(lists -> System.out.println("Students who have first name - Vlad" + list));
	
		session.getTransaction().commit();
	} finally {
		session.close();
	}
	}
}
