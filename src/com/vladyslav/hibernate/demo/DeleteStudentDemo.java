package com.vladyslav.hibernate.demo;

import java.util.List;
import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.vladyslav.demo.entity.Student;

public class DeleteStudentDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();
	
	try {
		
		session.beginTransaction();
		List<Student> student = session.createQuery("from Student").getResultList();
		session.delete(student.get(new Random().nextInt(student.size())));
		session.getTransaction().commit();;
		System.out.println("Done!");
	}finally {
		session.close();
	}
	}
}
