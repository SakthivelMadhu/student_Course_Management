package com.example.service;


import com.example.dto.StudentDTO;
import com.example.entity.Student;

import java.util.List;

public interface StudentService {

    Student admitStudent(StudentDTO studentDTO);

    Student updateStudentProfile(Long studentId, StudentDTO studentDTO);

    List<Student> findStudentsByName(String name);

    List<Student> findStudentsByCourse(Long courseId);

    void leaveCourse(Long studentId, Long courseId);

	Student admitStudent(Student student);
}

