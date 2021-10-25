package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

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

			// create the objects
			Instructor instructor = new Instructor("Shubham", "bhusri", "Shubham.bhusri@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube",
					"Luv 2 code!!!");

			// associate the objects or hook them up
			instructor.setInstrcutorDetail(instructorDetail); // now at this point these two objects are associated in
																// memory but not in db

			session.beginTransaction();

			// save the instructor
			// Note : this will also save the details object
			// because of CascadeType.ALL
			session.save(instructor);

			System.out.println("Saving instructor: " + instructor);

			// committ the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}

		finally {
			factory.close();
		}
	}

}
