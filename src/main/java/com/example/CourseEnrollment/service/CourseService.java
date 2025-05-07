package com.example.CourseEnrollment.service;

import com.example.CourseEnrollment.dto.CourseDTO;
import java.util.List;

public interface CourseService {
    CourseDTO saveCourse(CourseDTO courseDTO);
    CourseDTO getCourseById(Long id);
    List<CourseDTO> getAllCourses();
    void deleteCourse(Long id);
}


