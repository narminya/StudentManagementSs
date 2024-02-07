package com.example.ratings.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

public class CourseDto {
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CourseGetDto {
        private UUID id;
        private String title;
        private String description;
        private String instructor;
    }
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CoursePostDto {
        private String title;
        private String description;
        private String instructor;
        private String duration;
        private String price;
        private String level;
    }
}
