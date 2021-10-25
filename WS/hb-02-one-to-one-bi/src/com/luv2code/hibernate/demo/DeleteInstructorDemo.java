package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDemo {

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

			Instructor instructor = session.get(Instructor.class, 5); // 1 is the primary key of
																		// instructor
			System.out.println("Found instructor : " + instructor);

			// print associate instructor
			System.out.println("Associate Instructor detail : " + instructor.getInstrcutorDetail());

			// remove the associate object reference
			// break bi-directional link
			// this has been used for overcoming exception
			// Exception in thread "main" javax.persistence.EntityNotFoundException: deleted
			// object would be re-saved by cascade (remove deleted object from
			// associations): [com.luv2code.hibernate.demo.entity.InstructorDetail#4]
			// instructorDetail.getInstructor().setInstrcutorDetail(null);

			session.delete(instructor);

			// committ the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}

		finally {
			factory.close();
		}
	}
}
