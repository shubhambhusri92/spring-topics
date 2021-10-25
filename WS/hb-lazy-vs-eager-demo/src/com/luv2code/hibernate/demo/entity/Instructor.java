package com.luv2code.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name") // db column name
	private String firstName; // application column name

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "email")
	private String email;

	// setup a mapping between instructor and instructor detail
	@OneToOne(cascade = CascadeType.ALL) // Cascade All means apply same operations to the mapping table too
	@JoinColumn(name = "instructor_detail_id") // column name configured in instructor table for mapping and it is a
												// foreign key constraint
	private InstructorDetail instructorDetail;

	// here we have removed cascading deleted
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "instructor", cascade = CascadeType.ALL)
	private List<Course> courses; // List is using because of one to many relationship

	public Instructor() {

	}

	public Instructor(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InstructorDetail getInstrcutorDetail() {
		return instructorDetail;
	}

	public void setInstrcutorDetail(InstructorDetail instrcutorDetail) {
		this.instructorDetail = instrcutorDetail;
	}

	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}

	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}

	public List<Course> getCourse() {
		return courses;
	}

	public void setCourse(List<Course> course) {
		this.courses = course;
	}

	// add convenience methods for bi-directional relationship
	public void addCourse(Course tempCourse) {
		if (courses == null)
			courses = new ArrayList<>();

		courses.add(tempCourse);

		tempCourse.setInstructor(this);

	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", instrcutorDetail=" + instructorDetail + "]";
	}
}
