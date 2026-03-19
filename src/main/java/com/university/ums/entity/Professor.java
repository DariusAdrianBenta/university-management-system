package com.university.ums.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.metamodel.model.domain.MapPersistentAttribute;

@Entity
@Table(name = "professors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private boolean active;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "department _id")
//        private Department  department ;


//    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY)
//    private List<Course> courses;

}
