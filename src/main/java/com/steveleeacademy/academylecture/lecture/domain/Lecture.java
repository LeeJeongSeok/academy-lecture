package com.steveleeacademy.academylecture.lecture.domain;

import com.steveleeacademy.academylecture.lecture.form.LectureCreateForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Lecture {

    @Id @GeneratedValue
    @Column(name = "LECTURE_ID")
    private Long id;

    @OneToMany(mappedBy = "lecture")
    private List<Category> categories;

    @OneToMany(mappedBy = "lecture")
    private List<Keyword> keywords;

    private String title;
    private String content;
    private String writer;
    private String startTime;
    private String endTime;

    @OneToMany(mappedBy = "lecture")
    private List<Day> days;

    private LocalDate startDate;
    private LocalDate endDate;
    private String remainingLecture;
    private RegistStatus registStatus;
    private LectureStatus lectureStatus;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public void addCategory(Category category) {
        category.setCategory(category);
        this.categories.add(category);
    }

    public static Lecture createLectureBuilder(LectureCreateForm lectureCreateForm) {
        return Lecture.builder()
                .categories(new ArrayList<>())
                .keywords(new ArrayList<>())
                .title(lectureCreateForm.getTitle())
                .content(lectureCreateForm.getContent())
                .writer(lectureCreateForm.getWriter())
                .startTime(lectureCreateForm.getStartTime())
                .endTime(lectureCreateForm.getEndTime())
                .days(new ArrayList<>())
                .startDate(lectureCreateForm.getStartDate())
                .endDate(lectureCreateForm.getEndDate())
                .remainingLecture(lectureCreateForm.getRemainingLecture())
                .registStatus(lectureCreateForm.getRegistStatus())
                .lectureStatus(lectureCreateForm.getLectureStatus())
                .createDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
    }

}
