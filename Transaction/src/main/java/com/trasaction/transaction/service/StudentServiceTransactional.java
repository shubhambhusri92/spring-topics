package com.trasaction.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.trasaction.transaction.dao.StudentRepository;
import com.trasaction.transaction.model.Student;

@Service
public class StudentServiceTransactional {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private StudentRepository studentRepo;

	// In this scenario if the calling service method (i.e.
	// saveProductUsingPropogationRequired)has a transaction then this
	// method makes use of the same transaction otherwise it'll start a new
	// transaction of it's own
	@Transactional(propagation = Propagation.REQUIRED) // Or @Transactional as it's by default embedded with this
	// annotation
	public void saveStudentUsingPropogationRequired() {
		Student student = new Student();
		student.setUniversity("DBIT");
		studentRepo.save(student);
	}

	@Transactional(propagation = Propagation.SUPPORTS) // if the calling service method doesn't have a transaction then
														// the method will not create a new transaction and if it has
														// then this method makes use of the same transaction
	public void saveStudentUsingSupports() {
		Student student = new Student();
		student.setUniversity("DBIT");
		// restTemplate.getForObject("http://localhost:8580/api/data", Object.class);
		studentRepo.save(student);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED) // if the calling service method doesn't have a transaction
															// then
	// the method will not create a new transaction and if it has
	// then this method will still not create it's own transaction since it never
	// run in a transaction
	public void saveStudentUsingNotSupports() {
		Student student = new Student();
		student.setId(1233);
		student.setUniversity("DIT");
		studentRepo.save(student);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW) // if the calling service method doesn't have a transaction
	// then
// the method will create a new transaction and if it has
// then this method does not make use of existing transaction instead it creates it's own transaction since it always
// creates a new transaction
	public void saveProductUsingRequiresNewOnStudent() {
		Student student = new Student();
		student.setId(1233);
		student.setUniversity("DIT");
		studentRepo.save(student);
	}

	@Transactional(propagation = Propagation.NEVER) // if the calling service method doesn't have a transaction
	// then
	// the method will not create a new transaction and run without a transaction and if it has
	// then this method will throw an exception 
	// since this method never uses transaction
	public void saveProductUsingNeverOnStudent() {
		Student student = new Student();
		student.setId(1233);
		student.setUniversity("DIT");
		studentRepo.save(student);
	}

}
