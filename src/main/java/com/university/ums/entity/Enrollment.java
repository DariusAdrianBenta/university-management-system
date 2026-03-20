package com.university.ums.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
// Ensures that a student cannot be enrolled multiple times in the same course
@Table(
        name = "enrollments",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"student_id", "course_id"})
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Enrollment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate enrollmentDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EnrolmentStatus status;

    //RELATIONSHIPS

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "couse_id")
    private Course course;


}
