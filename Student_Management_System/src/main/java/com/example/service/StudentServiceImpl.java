package com.example.service;

import com.example.dto.StudentDTO;
import com.example.entity.Course;
import com.example.entity.Student;
import com.example.repository.StudentRepository;
import com.example.repository.CourseRepository; // Import CourseRepository

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException; // Import EntityNotFoundException
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository; // Autowire CourseRepository

    @Override
    public Student admitStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setGender(studentDTO.getGender());
        student.setUniqueStudentCode(studentDTO.getUniqueStudentCode());
        // You can set other properties as needed
        return studentRepository.save(student);
    }
    @Override
    public Student admitStudent(Student student) {
        // Implement logic to admit a student
        // You can save the student entity and return it
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentProfile(Long studentId, StudentDTO studentDTO) {
        try {
            Student student = studentRepository.getOne(studentId); // Use getOne to load the entity
            student.setEmail(studentDTO.getEmail());
            student.setMobileNumber(studentDTO.getMobileNumber());
            student.setParentsName(studentDTO.getParentsName());
            student.setAddress(studentDTO.getAddress());
            // Implement logic to update other properties as needed
            return studentRepository.save(student);
        } catch (EntityNotFoundException ex) {
            throw new RuntimeException("Student not found with ID: " + studentId);
        }
    }

    @Override
    public List<Student> findStudentsByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> findStudentsByCourse(Long courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            Course targetCourse = courseOptional.get();
            return targetCourse.getStudents();
        } else {
            throw new RuntimeException("Course not found with ID: " + courseId);
        }
    }

    @Override
    public void leaveCourse(Long studentId, Long courseId) {
        try {
            Student student = studentRepository.getOne(studentId); // Use getOne to load the entity
            Course course = courseRepository.getOne(courseId); // Use getOne to load the entity

            // Remove the course from the student's list of courses
            student.getCourses().remove(course);
            studentRepository.save(student);
        } catch (EntityNotFoundException ex) {
            throw new RuntimeException("Student or Course not found.");
        }
    }
}
