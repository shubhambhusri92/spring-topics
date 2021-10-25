package com.trasaction.transaction.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trasaction.transaction.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
