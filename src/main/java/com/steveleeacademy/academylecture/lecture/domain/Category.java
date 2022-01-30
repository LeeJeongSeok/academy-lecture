package com.steveleeacademy.academylecture.lecture.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    public Category(String category) {
        this.category = category;
    }

    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;

    public void setCategory(Lecture lecture) {
        this.lecture = lecture;
    }

}
