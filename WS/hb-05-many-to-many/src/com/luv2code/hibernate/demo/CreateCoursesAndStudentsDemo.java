package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesAndStudentsDemo {

	public static void main(String[] args) {

		// create Session Factory
		// Session Factory created only once per application

		// addAnnotatedClass : these are the entity classes which hibernate should know
		// about them and load them and make them available
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class).addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();

		// create Session
		// sessions can be created n number of times as per our use
		Session session = factory.getCurrentSession();

		try {

			// start the transaction
			session.beginTransaction();

			// create a course
			Course tempCourse = new Course("Java");
			session.save(tempCourse);

			Student student1 = new Student("Shubham", "Bhusri", "Shubham.bhusri@nagarro.com");
			Student student2 = new Student("Payal", "Bhusri", "payal.bhusri@nagarro.com");

			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);

			session.save(student1);
			session.save(student2);

			// commit transaction
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
