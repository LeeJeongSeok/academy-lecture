package com.steveleeacademy.academylecture.lecture.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Lecture {

    @Id @GeneratedValue
    @Column(name = "LECTURE_ID")
    private Long id;

    @OneToMany(mappedBy = "lecture")
    private List<Category> categorys;

    @OneToMany(mappedBy = "lecture")
    private List<Keyword> keywords;

    private String title;
    private String content;
    private String writer;
    private String startTime;
    private String endTime;

    @OneToMany(mappedBy = "lecture")
    private List<Day> days;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String times;
    private RegistStatus registStatus;
    private LectureStatus lectureStatus;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

}
