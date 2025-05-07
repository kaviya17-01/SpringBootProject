package com.example.CourseEnrollment.repository;

import com.example.CourseEnrollment.model.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}

