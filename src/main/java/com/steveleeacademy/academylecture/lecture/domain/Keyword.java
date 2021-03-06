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
public class Keyword {

    public Keyword(String keyword) {
        this.keyword = keyword;
    }

    @Id @GeneratedValue
    @Column(name = "KEYWORD_ID")
    private Long id;
    private String keyword;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;

    public void setKeyword(Lecture lecture) {
        this.lecture = lecture;
    }

}
