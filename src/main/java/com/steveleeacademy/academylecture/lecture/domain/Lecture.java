package com.steveleeacademy.academylecture.lecture.domain;

import com.steveleeacademy.academylecture.lecture.form.LectureCreateForm;
import com.steveleeacademy.academylecture.lecture.form.LectureUpdateForm;
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

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Keyword> keywords = new ArrayList<>();

    private String title;
    private String content;
    private String writer;
    private String startTime;
    private String endTime;

    @OneToMany(mappedBy = "lecture", cascade = CascadeType.ALL)
    private List<Day> days = new ArrayList<>();

    private LocalDate startDate;
    private LocalDate endDate;
    private String remainingLecture;

    @Enumerated(value = EnumType.STRING)
    private RegistStatus registStatus;

    @Enumerated(value = EnumType.STRING)
    private LectureStatus lectureStatus;

    private LocalDateTime createDate;
    private LocalDateTime updateDate;
    private LocalDateTime deleteDate;

    public void addCategory(Category category) {
        category.setCategory(this);
        this.categories.add(category);
    }

    public void addDay(Day day) {
        day.setDay(this);
        this.days.add(day);
    }

    public void addKeyword(Keyword keyword) {
        keyword.setKeyword(this);
        this.keywords.add(keyword);
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

    public static Lecture updateLectureBuilder(LectureUpdateForm lectureUpdateForm) {
        return Lecture.builder()
                .id(lectureUpdateForm.getId())
                .categories(new ArrayList<>())
                .keywords(new ArrayList<>())
                .title(lectureUpdateForm.getTitle())
                .content(lectureUpdateForm.getContent())
                .writer(lectureUpdateForm.getWriter())
                .startTime(lectureUpdateForm.getStartTime())
                .endTime(lectureUpdateForm.getEndTime())
                .days(new ArrayList<>())
                .startDate(lectureUpdateForm.getStartDate())
                .endDate(lectureUpdateForm.getEndDate())
                .remainingLecture(lectureUpdateForm.getRemainingLecture())
                .registStatus(lectureUpdateForm.getRegistStatus())
                .lectureStatus(lectureUpdateForm.getLectureStatus())
                .updateDate(LocalDateTime.now())
                .build();
    }

}
