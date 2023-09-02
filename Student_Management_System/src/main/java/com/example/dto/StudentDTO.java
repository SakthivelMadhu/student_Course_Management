package com.example.dto;


public class StudentDTO {

    private String name;
    private String dateOfBirth;
    private String gender;
    private String uniqueStudentCode;
	public StudentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StudentDTO(String name, String dateOfBirth, String gender, String uniqueStudentCode) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.uniqueStudentCode = uniqueStudentCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUniqueStudentCode() {
		return uniqueStudentCode;
	}
	public void setUniqueStudentCode(String uniqueStudentCode) {
		this.uniqueStudentCode = uniqueStudentCode;
	}
	@Override
	public String toString() {
		return "StudentDTO [name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender
				+ ", uniqueStudentCode=" + uniqueStudentCode + "]";
	}
	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getMobileNumber() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getParentsName() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

    
}

