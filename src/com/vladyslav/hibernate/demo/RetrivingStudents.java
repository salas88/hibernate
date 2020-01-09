package com.vladyslav.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.demo.entity.Student;

public class RetrivingStudents {
	
	private static List<Student> list;
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();
	
	try {
	
		session.beginTransaction();
		
		
	 list = session.createQuery("from Student").getResultList();
		
		// display Students
		list.forEach(temp -> System.out.println(temp));
		
		// query Students 
		list = session.createQuery("from Student s where s.firstName='Vlad'").getResultList();
		
		// display Students
		list.forEach(temp -> System.out.println("Students who have first name - Vlad" + temp));
		
		// query Students 
		list = session.createQuery("from Student s where "
				+ "s.lastName='Osmachko' OR s.email LIKE '%gmail.com'").getResultList();
		
		// display Students
		list.forEach(temp -> System.out.println("Students who have last name Osmachko or who has"
				+ "google mail" + temp));
	
		session.getTransaction().commit();
	} finally {
		session.close();
	}
	}
}
