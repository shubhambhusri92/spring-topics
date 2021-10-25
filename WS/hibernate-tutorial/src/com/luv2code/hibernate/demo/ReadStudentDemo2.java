package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo2 {

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
			Student stud = new Student("Daffy", "Duck", "Daffy.duck@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving student");
			session.save(stud);

			// committ the transaction
			session.getTransaction().commit();

			// find out the student's primary key: primary key
			System.out.println("Generated Id after saving student is:" + stud.getId());
			
			// get a new session and start a transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieve a student based on the id: primary key
			System.out.println("\nGetting student with id: " + stud.getId());
			Student student = session.get(Student.class, stud.getId());
			
			System.out.println("Get Complete :" + student);
			
			//committ the transaction
			session.getTransaction().commit();	
			
			
			System.out.println("Done!");
		}

		finally {
			factory.close();
		}
	}

}
