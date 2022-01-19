package com.steveleeacademy.academylecture.lecture.domain;

import javax.persistence.*;

@Entity
public class Day {

    @Id @GeneratedValue
    @Column(name = "DAY_ID")
    private Long id;
    private String day;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;
}
