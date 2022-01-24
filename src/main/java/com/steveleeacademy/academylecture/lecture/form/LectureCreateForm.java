package com.steveleeacademy.academylecture.lecture.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.steveleeacademy.academylecture.lecture.domain.*;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
public class LectureCreateForm {

    private List<String> categories;
    private List<String> keywords;

    @NotEmpty(message = "강좌명은 필수 입력입니다.")
    private String title;

    @NotEmpty(message = "강의내용은 필수 입력입니다.")
    private String content;

    @NotEmpty(message = "강사명은 필수 입력입니다.")
    private String writer;

    private String startTime;
    private String endTime;
    private List<String> days;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDate endDate;

    private String remainingLecture;
    private RegistStatus registStatus;
    private LectureStatus lectureStatus;
}
