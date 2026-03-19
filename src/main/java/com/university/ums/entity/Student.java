package com.university.ums.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

private LocalDate enrollmentDate;

private boolean active;
@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

//@OneToMany(mappedBy = "student",fetch = FetchType.LAZY)
//    private List<Enrollment> enrollments;






}
