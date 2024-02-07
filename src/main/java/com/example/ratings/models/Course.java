package com.example.ratings.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID course_id;
    private String title;
    private String description;
    private String instructor;
    private String duration;
    private String price;
    private String level;

    @OneToMany(mappedBy = "course",fetch = FetchType.EAGER)
    List<Subscription> ratings;

}
