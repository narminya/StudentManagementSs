package com.example.ratings.service.impl;

import com.example.ratings.dto.StudentDto.StudentPostDto;

import com.example.ratings.models.Student;
import com.example.ratings.repository.IRepository;
import com.example.ratings.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @Qualifier("student")
    private final IRepository repository;

    @Override
    public List<Student> getStudents() {
       return repository.findAll();
    }

    @Override
    public Student getStudent(UUID id) {
        return (Student)repository.findById(id);
    }

    @Override
    public Student deleteStudent(UUID sid) {
       return (Student)repository.deleteById(sid);
    }

    @Override
    public Student saveStudent(UUID sid, Student dto) {
        return null;
    }

    @Override
    public Student saveStudent(Student student) {
       repository.save(student);
       return student;
    }


}
