package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create Session Factory
		// Session Factory created only once per application

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create Session
		// sessions can be created n number of times as per our use
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save the object

			// create the student object
			System.out.println("Creating a new Student Object..");
			Student stud = new Student("Shubham", "Bhusri", "Shubham.bhusri97@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(stud);

			// committ the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}

		finally {
			factory.close();
		}
	}

}
