package com.example.CourseEnrollment.service;

import com.example.CourseEnrollment.dto.EnrollmentDTO;

import java.util.List;

public interface EnrollmentService {
    EnrollmentDTO enrollStudent(EnrollmentDTO enrollmentDTO);
    List<EnrollmentDTO> getAllEnrollments();
    void deleteEnrollment(Long id);
}


