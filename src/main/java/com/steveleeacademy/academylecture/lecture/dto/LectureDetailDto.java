package com.steveleeacademy.academylecture.lecture.dto;


import com.steveleeacademy.academylecture.lecture.domain.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class LectureDetailDto {

    private List<Category> categories;
    private List<Keyword> keywords;
    private String title;
    private String content;
    private String writer;
    private String startTime;
    private String endTime;
    private List<Day> days;
    private LocalDate startDate;
    private LocalDate endDate;
    private String remainingLeture;
    private RegistStatus registStatus;
    private LectureStatus lectureStatus;

    public static LectureDetailDto createLectureDetailDto(Lecture lecture) {
        return LectureDetailDto.builder()
                .categories(lecture.getCategories())
                .keywords(lecture.getKeywords())
                .title(lecture.getTitle())
                .content(lecture.getContent())
                .writer(lecture.getWriter())
                .startTime(lecture.getStartTime())
                .endTime(lecture.getEndTime())
                .days(lecture.getDays())
                .startDate(lecture.getStartDate())
                .endDate(lecture.getEndDate())
                .remainingLeture(lecture.getRemainingLecture())
                .registStatus(lecture.getRegistStatus())
                .lectureStatus(lecture.getLectureStatus())
                .build();
    }
}
