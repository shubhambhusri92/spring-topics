package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> list;

	// define @PostConstruct to load the student data .. only once !
	// @PostConstruct is called only once when the bean is been constructed
	@PostConstruct
	public void loadData() {
		list = new ArrayList<Student>();

		Student student1 = new Student("Shubham", "Bhusri");
		Student student2 = new Student("Payal", "Arora");
		Student student3 = new Student("Shreya", "Shrivastava");

		list.add(student1);
		list.add(student2);
		list.add(student3);
	}

	// define end point for /students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return list;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {

		// check the sudent id aginst list size
		if (studentId >= list.size() || (studentId < 0))
			throw new StudentNotFoundException("Student not found with id :" + studentId);

		return list.get(studentId);
	}

	// here we have commented the exception handler code because we have moved it to
	// global in StudentRestExceptionHandler using @ControllerAdvice
	/*
	 * // add an exception handler using @Exceptionhandler
	 * 
	 * @ExceptionHandler public ResponseEntity<StudentErrorResponse>
	 * handleException(StudentNotFoundException ex) { StudentErrorResponse
	 * errorresponse = new StudentErrorResponse();
	 * errorresponse.setStatus(HttpStatus.NOT_FOUND.value());
	 * errorresponse.setMessage(ex.getMessage());
	 * errorresponse.setTimeStamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(errorresponse, HttpStatus.NOT_FOUND);
	 * 
	 * }
	 * 
	 * // add another exception handler .. to try catch any exception (catch all)
	 * 
	 * @ExceptionHandler public ResponseEntity<StudentErrorResponse>
	 * handleException(Exception ex) { StudentErrorResponse errorresponse = new
	 * StudentErrorResponse();
	 * errorresponse.setStatus(HttpStatus.BAD_REQUEST.value());
	 * errorresponse.setMessage(ex.getMessage());
	 * errorresponse.setTimeStamp(System.currentTimeMillis());
	 * 
	 * return new ResponseEntity<>(errorresponse, HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */
}
