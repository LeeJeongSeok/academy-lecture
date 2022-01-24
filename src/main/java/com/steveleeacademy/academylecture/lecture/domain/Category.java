package com.steveleeacademy.academylecture.lecture.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    public Category(String category) {
        this.categoryName = categoryName;
    }

    @Id @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private Long id;

    private String categoryName;

    @ManyToOne
    @JoinColumn(name = "LECTURE_ID")
    private Lecture lecture;

    public void setCategory(Category category) {
        this.lecture = lecture;
    }

}
