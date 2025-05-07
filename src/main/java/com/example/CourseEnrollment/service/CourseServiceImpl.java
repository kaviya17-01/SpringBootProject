package com.example.CourseEnrollment.service;

import com.example.CourseEnrollment.dto.CourseDTO;
import com.example.CourseEnrollment.exception.ResourceNotFoundException;
import com.example.CourseEnrollment.model.Course;
import com.example.CourseEnrollment.repository.CourseRepository;
import com.example.CourseEnrollment.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

@Autowired
private CourseRepository courseRepository;

@Override
public CourseDTO saveCourse(CourseDTO courseDTO) {
    Course course = new Course();
    course.setTitle(courseDTO.getTitle());
    course.setDescription(courseDTO.getDescription());

    Course savedCourse = courseRepository.save(course);
    return DTOMapper.toCourseDTO(savedCourse);
}

@Override
public CourseDTO getCourseById(Long id) {
    Course course = courseRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Course not found with ID: " + id));
    return DTOMapper.toCourseDTO(course);
}

@Override
public List<CourseDTO> getAllCourses() {
    return courseRepository.findAll()
            .stream()
            .map(DTOMapper::toCourseDTO)
            .collect(Collectors.toList());
}

@Override
public void deleteCourse(Long id) {
    courseRepository.deleteById(id);
}

}
