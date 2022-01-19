package com.steveleeacademy.academylecture.lecture.domain;

import javax.persistence.*;

@Entity
public class Keyword {

    @Id @GeneratedValue
    @Column(name = "KEYWORD_ID")
    private Long id;
    private String keywordName;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;

}
