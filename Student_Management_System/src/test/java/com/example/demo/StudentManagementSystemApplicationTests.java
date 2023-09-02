package com.example.demo;


import com.example.service.StudentService;
import com.example.dto.StudentDTO;
import com.example.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional // To roll back the changes made during tests (if using an embedded database)
public class StudentManagementSystemApplicationTests {

    @Autowired
    private StudentService studentService;

    @Test
    public void testAdmitStudent() {
        // Create a sample student
        Student student = new Student();
        student.setName("Sakthivel Madhu");
        student.setDateOfBirth("1995-01-01");
        student.setGender("Male");

        // Admit the student
        Student admittedStudent = studentService.admitStudent(student);

        // Check if the student is not null
        assertNotNull(admittedStudent);

        // Check if the student's ID is generated
        assertNotNull(admittedStudent.getId());

        // Check if the student's name matches
        assertEquals("Sakthivel Madhu", admittedStudent.getName());
    }

    

}

