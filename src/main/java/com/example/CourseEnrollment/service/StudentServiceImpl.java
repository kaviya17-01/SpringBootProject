package com.example.CourseEnrollment.service;

import com.example.CourseEnrollment.dto.StudentDTO;
import com.example.CourseEnrollment.exception.ResourceNotFoundException;
import com.example.CourseEnrollment.model.Student;
import com.example.CourseEnrollment.repository.StudentRepository;
import com.example.CourseEnrollment.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDTO saveStudent(StudentDTO studentDTO) {
        Student student = DTOMapper.toStudentEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return DTOMapper.toStudentDTO(savedStudent);
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id));
        return DTOMapper.toStudentDTO(student);
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(DTOMapper::toStudentDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}




