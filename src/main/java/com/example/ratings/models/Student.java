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
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID student_id;
    private String name;
    private String email;
    private String password_hash;
    private String address;
    private String phone_number;


    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    List<Subscription> ratings;
}
