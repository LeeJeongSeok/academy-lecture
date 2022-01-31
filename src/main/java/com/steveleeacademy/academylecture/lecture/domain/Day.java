package com.steveleeacademy.academylecture.lecture.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Day {

    public Day(String day) {
        this.day = day;
    }

    @Id @GeneratedValue
    @Column(name = "DAY_ID")
    private Long id;
    private String day;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;

    public void setDay(Lecture lecture) {
        this.lecture = lecture;
    }
}
