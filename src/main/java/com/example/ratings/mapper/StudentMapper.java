package com.example.ratings.mapper;

import com.example.ratings.dto.CourseDto;
import com.example.ratings.dto.StudentDto;
import com.example.ratings.dto.StudentDto.StudentGetDto;
import com.example.ratings.models.Course;
import com.example.ratings.models.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class StudentMapper {


    private final ModelMapper modelMapper;

    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }


    public StudentGetDto mapStudentToDto(Student student) {
        return Optional.ofNullable(student)
                .map(s -> {
                    StudentGetDto studentDto = modelMapper.map(s, StudentGetDto.class);
                    studentDto.setCourse(
                            s.getRatings().stream()
                                    .map(subscription -> mapCourseToDto(subscription.getCourse()))
                                    .collect(Collectors.toList())
                    );
                    return studentDto;
                })
                .orElse(null);
    }
    public Student mapDtoToStudent(StudentDto.StudentPostDto studentDto) {
        return Optional.ofNullable(studentDto)
                .map(s -> {
                    return modelMapper.map(s, Student.class);
                })
                .orElse(null);
    }
    public List<StudentGetDto> mapStudentsToDto(List<Student> students) {
        return students.stream()
                .map(this::mapStudentToDto)
                .collect(Collectors.toList());
    }

    public CourseDto.CourseGetDto mapCourseToDto(Course course) {
        return modelMapper.map(course, CourseDto.CourseGetDto.class);
    }

    public List<CourseDto.CourseGetDto> mapCoursesToDto(List<Course> courses) {
        return courses.stream()
                .map(this::mapCourseToDto)
                .collect(Collectors.toList());
    }


}
