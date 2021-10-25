package com.luv2code.hibernate.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class AddCoursesForPayalDemo {

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

			// Note : everything works in a single session

			// start the transaction
			session.beginTransaction();

			Instructor instructor = session.get(Instructor.class, 2);

			System.out.println("Instructor :" + instructor);

			Student student = session.get(Student.class, 2);
			System.out.println("Student is : " + student);

			System.out.println("Course Associated with student :" + student.getCourses());

			Course tempCourse = new Course("Cloud COm");

			session.save(tempCourse);

			List<Course> course = new ArrayList<>();
			course.add(tempCourse);

			student.setCourses(course);
			student.setLastName("Arora");

			instructor.setEmail("jai@gmail.com");
			// create a course
			// tempCourse.addStudent(student);

			// session.save(tempCourse);

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
