package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class DeleteCourseDemo {

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

			// Course course = session.get(Course.class, 10);

			Instructor instructor = session.get(Instructor.class, 1);

			System.out.println("Course Found : " + instructor);

			List<Course> list = instructor.getCourse();

			for (Course c : list) {
				c.setInstructor(null);
			}

			session.delete(instructor);

			// No need to commit the transaction as we are fetching the data we are not
			// applying changes to db

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
