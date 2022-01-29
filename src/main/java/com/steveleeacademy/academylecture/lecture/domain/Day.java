package com.steveleeacademy.academylecture.lecture.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Day {

    @Id @GeneratedValue
    @Column(name = "DAY_ID")
    private Long id;
    private String day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;
}
