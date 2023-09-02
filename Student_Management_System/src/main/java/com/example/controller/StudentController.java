package com.example.controller;


import com.example.dto.StudentDTO;
import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/admit")
    public Student admitStudent(@RequestBody StudentDTO studentDTO) {
        return studentService.admitStudent(studentDTO);
    }

    @PutMapping("/{studentId}")
    public Student updateStudentProfile(@PathVariable Long studentId, @RequestBody StudentDTO studentDTO) {
        return studentService.updateStudentProfile(studentId, studentDTO);
    }

    @GetMapping("/search")
    public List<Student> findStudentsByName(@RequestParam String name) {
        return studentService.findStudentsByName(name);
    }

    @GetMapping("/course/{courseId}")
    public List<Student> findStudentsByCourse(@PathVariable Long courseId) {
        return studentService.findStudentsByCourse(courseId);
    }

    @DeleteMapping("/{studentId}/course/{courseId}")
    public void leaveCourse(@PathVariable Long studentId, @PathVariable Long courseId) {
        studentService.leaveCourse(studentId, courseId);
    }
}

