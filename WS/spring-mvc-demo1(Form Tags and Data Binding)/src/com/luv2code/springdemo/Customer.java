package com.luv2code.springdemo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.luv2code.springdemo.validation.CourseCode;

public class Customer {

	private String firstName;

	// validation
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;

	// validate a number range
	@NotNull(message = "is required")
	@Min(value = 0, message = "must be grater than or equal to zero")
	@Max(value = 10, message = "must be less than or equal to 10")
	private Integer freePasses;

	// regex validation
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 char/digits")
	private String postalCode;

	// Here for custom annotation if we want to override the value pass value and
	// message like @CourseCode(value = "SHUBH", message = "must start with SHUBH")
	// and for using default values passed in annotation interface use @CourseCode
	// @CourseCode
	@CourseCode(value = "SHUBH", message = "must start with SHUBH")
	private String courseCode;

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

	public Integer getFreePasses() {
		return freePasses;
	}

	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", freePasses=" + freePasses
				+ ", postalCode=" + postalCode + "]";
	}

}
