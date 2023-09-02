package com.example.repository;


import com.example.entity.Course;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {

	 // Find courses by course name
    List<Course> findByCourseName(String courseName);

    // Find courses by course type
    List<Course> findByCourseType(String courseType);

    // Find courses by duration less than a specified value
    List<Course> findByDurationLessThan(int duration);

    // Find courses that contain a specific topic
    List<Course> findByTopicsContaining(String topic);
}

