package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo3 {

	public static void main(String[] args) {

		// create Session Factory
		// Session Factory created only once per application

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session
		// sessions can be created n number of times as per our use
		Session session = factory.getCurrentSession();

		try {

			int studentId = 1;

			// start a transaction
			session.beginTransaction();

			// retrieve a student based on the id: primary key
			System.out.println("\nGetting student with id: " + studentId);
			Student student = session.get(Student.class, studentId);

			System.out.println("Updating Student -----");
			student.setFirstName("Chirag");

			// committ the transaction
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Update email address for all students---");
			// update email for all students
			session.createQuery("update Student set email='Chirag.bhusri1@gmail.com'").executeUpdate();
			session.getTransaction().commit();
			System.out.println("Done!");
		}

		finally {
			factory.close();
		}
	}

}
