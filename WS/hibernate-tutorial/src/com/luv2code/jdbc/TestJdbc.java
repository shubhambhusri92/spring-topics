package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author shubhambhusri
 *
 */

// This class is used for testing the connection with MySQL DB
public class TestJdbc {

	public static void main(String[] args) {

		// hb_student-tracker is our schema
		// use SSL = false is for get rid of MYSQL SSL Warnings
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {

			System.out.println("Connecting to DB :" + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, password);
			System.out.println("Connection successful!!!");
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
