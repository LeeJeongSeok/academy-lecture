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
public class Category {

    public Category(String category) {
        this.category = category;
    }

    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String category;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;

    public void setCategory(Lecture lecture) {
        this.lecture = lecture;
    }

}
