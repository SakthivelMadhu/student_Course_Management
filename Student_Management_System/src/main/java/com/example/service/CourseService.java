package com.example.service;


import com.example.dto.CourseDTO;
import com.example.entity.Course;
import com.example.entity.Student;

import java.util.List;

public interface CourseService {

    Course createCourse(CourseDTO courseDTO);

    List<Course> getAllCourses();

    List<Course> getCoursesForStudent(Long studentId);

    void assignCourseToStudent(Long courseId, Long studentId);
}

