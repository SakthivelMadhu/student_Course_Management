package com.example.controller;

import com.example.dto.CourseDTO;
import com.example.entity.Course;
import com.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/create")
    public Course createCourse(@RequestBody CourseDTO courseDTO) {
        return courseService.createCourse(courseDTO);
    }

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/student/{studentId}")
    public List<Course> getCoursesForStudent(@PathVariable Long studentId) {
        return courseService.getCoursesForStudent(studentId);
    }

    @PostMapping("/assign/{courseId}/student/{studentId}")
    public void assignCourseToStudent(@PathVariable Long courseId, @PathVariable Long studentId) {
        courseService.assignCourseToStudent(courseId, studentId);
    }
}


