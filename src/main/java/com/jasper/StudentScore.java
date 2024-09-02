package com.jasper;

public class StudentScore {

	private String subjectName;

	private Double totalMarks;

	private Double obtained;

	public StudentScore(String subjectName, Double totalMarks, Double obtained) {
		super();
		this.subjectName = subjectName;
		this.totalMarks = totalMarks;
		this.obtained = obtained;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Double getTotalMarks() {
		return totalMarks;
	}

	public void setTotalMarks(Double totalMarks) {
		this.totalMarks = totalMarks;
	}

	public Double getObtained() {
		return obtained;
	}

	public void setObtained(Double obtained) {
		this.obtained = obtained;
	}

}
