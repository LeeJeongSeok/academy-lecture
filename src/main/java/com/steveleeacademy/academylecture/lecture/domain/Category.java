package com.steveleeacademy.academylecture.lecture.domain;

import javax.persistence.*;

@Entity
public class Category {

    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;
}
