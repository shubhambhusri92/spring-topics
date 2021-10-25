package com.luv2code.springdemo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author shubhambhusri
 *
 */
public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	// spring mvc will call isValid for checking
	// the code is the value passed from html form
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		boolean result;

		if (theCode != null) {
			result = theCode.startsWith(coursePrefix);
		}

		else {
			result = true;
		}

		return result;
	}

}
