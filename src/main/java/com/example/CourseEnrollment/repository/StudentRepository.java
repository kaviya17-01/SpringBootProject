package com.example.CourseEnrollment.repository;

import com.example.CourseEnrollment.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    // You can add custom query methods here if needed
}

