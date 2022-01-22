package com.steveleeacademy.academylecture.lecture.form;

import com.steveleeacademy.academylecture.lecture.domain.*;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class LectureCreateForm {

    private List<Category> categories;
    private List<Keyword> keywords;

    @NotNull
    private String title;
    private String content;
    private String writer;
    private String startTime;
    private String endTime;
    private List<Day> days;
    private LocalDateTime stratDate;
    private LocalDateTime endDate;
    private String remainingLecture;
    private RegistStatus registStatus;
    private LectureStatus lectureStatus;
}
