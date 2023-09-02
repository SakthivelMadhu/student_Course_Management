package com.example.repository;


import com.example.entity.Student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

	 // Find students by name
    List<Student> findByName(String name);

    // Find students by gender
    List<Student> findByGender(String gender);

    // Find students born after a certain date of birth
    List<Student> findByDateOfBirthAfter(LocalDate dateOfBirth);

    // Find students assigned to a specific course
    List<Student> findByCoursesId(Long courseId);
}
