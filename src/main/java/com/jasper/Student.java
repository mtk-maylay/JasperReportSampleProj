package com.jasper;

public class Student {

	private String name;

	private String year;

	private String advisior;

	private String gradingPeriod;

	public Student(String name, String year, String advisior, String gradingPeriod) {
		super();
		this.name = name;
		this.year = year;
		this.advisior = advisior;
		this.gradingPeriod = gradingPeriod;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getAdvisior() {
		return advisior;
	}

	public void setAdvisior(String advisior) {
		this.advisior = advisior;
	}

	public String getGradingPeriod() {
		return gradingPeriod;
	}

	public void setGradingPeriod(String gradingPeriod) {
		this.gradingPeriod = gradingPeriod;
	}

}
