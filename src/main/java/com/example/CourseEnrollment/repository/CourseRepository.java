package com.example.CourseEnrollment.repository;


import com.example.CourseEnrollment.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

