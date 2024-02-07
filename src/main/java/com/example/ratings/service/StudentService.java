package com.example.ratings.service;
import com.example.ratings.dto.StudentDto.StudentGetDto;
import com.example.ratings.dto.StudentDto.StudentPostDto;

import com.example.ratings.models.Student;
import java.util.List;
import java.util.UUID;

public interface StudentService {
    List<Student> getStudents();
    Student getStudent(UUID id);
    public Student deleteStudent(UUID sid);
    Student saveStudent(UUID sid, Student student);
    Student saveStudent(Student student);

}
