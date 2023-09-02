package com.example.dto;


public class CourseDTO {

    private String courseName;
    private String description;
    private String courseType;
    private int duration;
	public CourseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourseDTO(String courseName, String description, String courseType, int duration) {
		super();
		this.courseName = courseName;
		this.description = description;
		this.courseType = courseType;
		this.duration = duration;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "CourseDTO [courseName=" + courseName + ", description=" + description + ", courseType=" + courseType
				+ ", duration=" + duration + "]";
	}

    
}
