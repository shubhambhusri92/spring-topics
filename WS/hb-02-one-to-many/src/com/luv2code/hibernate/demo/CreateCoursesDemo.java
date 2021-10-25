package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {

	public static void main(String[] args) {

		// create Session Factory
		// Session Factory created only once per application

		// addAnnotatedClass : these are the entity classes which hibernate should know
		// about them and load them and make them available
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create Session
		// sessions can be created n number of times as per our use
		Session session = factory.getCurrentSession();

		try {

			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, 1);

			// create courses
			Course tempCourse1 = new Course("Cobol - The Ultimate Guide");
			Course tempCourse2 = new Course("Cloud Computing - The Ultimate Guide");

			// add courses to instructor
			instructor.addCourse(tempCourse1);
			instructor.addCourse(tempCourse2);

			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);

			System.out.println("Saving instructor: " + instructor);

			// committ the transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		}

		finally {
			// add clean up code for leaking
			session.close();
			factory.close();
		}
	}

}
