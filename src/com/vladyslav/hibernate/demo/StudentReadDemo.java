package com.vladyslav.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.demo.entity.Student;

public class StudentReadDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();
	session.beginTransaction();
	int id =1;
	Student theStudent = session.get(Student.class,id);
	System.out.println(theStudent);
	session.getTransaction().commit();;
	
	}
}
