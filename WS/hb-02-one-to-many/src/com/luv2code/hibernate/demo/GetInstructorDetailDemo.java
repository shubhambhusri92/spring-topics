package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {

		// create Session Factory
		// Session Factory created only once per application

		// addAnnotatedClass : these are the entity classes which hibernate should know
		// about them and load them and make them available
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create Session
		// sessions can be created n number of times as per our use
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			InstructorDetail instructor = session.get(InstructorDetail.class, 2); // 1 is the primary key of instructor
			System.out.println("Found instructor detail: " + instructor);

			// print associate instructor
			System.out.println("Associate Instructor : " + instructor.getInstructor());

			// committ the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}

		finally {
			factory.close();
		}
	}

}
