package com.example.ratings.controllers;

import com.example.ratings.dto.StudentDto;
import com.example.ratings.dto.StudentDto.StudentGetDto;
import com.example.ratings.mapper.StudentMapper;
import com.example.ratings.models.Student;
import com.example.ratings.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/student")
public class StudentController {
    private final StudentService service;
    private final StudentMapper mapper;

    @GetMapping
    public ResponseEntity<List<StudentGetDto>> getStudents(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname
    ) {
        return ResponseEntity.ok(mapper.mapStudentsToDto(service.getStudents()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentGetDto> getStudent(@PathVariable UUID id) {
        return ResponseEntity.of(Optional.ofNullable(mapper.mapStudentToDto(service.getStudent(id))));
    }

    @PostMapping
    public ResponseEntity<StudentGetDto> getStudent(@RequestBody StudentDto.StudentPostDto dto) {
       Student mapped = service.saveStudent(mapper.mapDtoToStudent(dto));
        return ResponseEntity.of(Optional.ofNullable(mapper.mapStudentToDto(mapped)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StudentGetDto> deleteStudent(@PathVariable UUID id) {
        return Optional.ofNullable(mapper.mapStudentToDto(service.deleteStudent(id)))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
