package com.vladyslav.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.demo.entity.Student;

public class StudentDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();
	
	try {
		Student tempStudent = new Student("Vlad", "Pikalov", "pikalov@gmail.com");
		Student tempStudent1 = new Student("Nikita", "Ze", "pikalov@gmail.com");
		session.beginTransaction();
		session.save(tempStudent);
		session.save(tempStudent1);
		session.getTransaction().commit();;
		System.out.println("Done!");
	}finally {
		session.close();
	}
	}
}
