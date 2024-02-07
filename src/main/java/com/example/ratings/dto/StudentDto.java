package com.example.ratings.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

public class StudentDto {
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentGetDto {
        private UUID student_id;
        private String name;
        private String email;
        private String password_hash;
        private String address;
        private String phone_number;

        List<CourseDto.CourseGetDto> course;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class StudentPostDto {
        private String name;
        private String email;
        private String password_hash;
        private String address;
        private String phone_number;
    }

}
