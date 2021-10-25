package com.luv2.code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {

		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();

			// read json file and map to Java POJO

			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println(student);

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
