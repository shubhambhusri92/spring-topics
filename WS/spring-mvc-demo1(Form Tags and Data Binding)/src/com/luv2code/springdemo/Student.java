package com.luv2code.springdemo;

import java.util.LinkedHashMap;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private LinkedHashMap<String, String> countryOptions;
	private String favoriteLanguage;
    private String[] operatingSystem;
	
	public Student() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("BR", "Brazil");
		countryOptions.put("IN", "India");
		countryOptions.put("GR", "Germany");
	}

	public String getFirstName() {
		System.out.println("Calling get First Name" + firstName);
		return firstName;
	}

	public void setFirstName(String firstName) {
		System.out.println("Calling Set First Name" + firstName);
		this.firstName = firstName;
	}

	public String getLastName() {
		System.out.println("Calling get Last Name" + lastName);
		return lastName;
	}

	public void setLastName(String lastName) {
		System.out.println("Calling Set Last Name" + lastName);
		this.lastName = lastName;
	}

	public String getCountry() {
		System.out.println("Calling get Country Name" + country);
		return country;
	}

	public void setCountry(String country) {
		System.out.println("Calling Set Country Name" + country);
		this.country = country;
	}

	// when form is loaded spring will call student.getCountryOptions
	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String[] getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String[] operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + "]";
	}

}
