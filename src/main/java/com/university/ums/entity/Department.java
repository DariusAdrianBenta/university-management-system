package com.university.ums.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "departments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    private String description;

// RELATIONSHIPS
    @OneToMany(mappedBy = "professor_id", fetch = FetchType.LAZY)
    private List<Professor> professors;

    @OneToMany(mappedBy = "course_id",fetch = FetchType.LAZY)
   private List<Course> course;










}
