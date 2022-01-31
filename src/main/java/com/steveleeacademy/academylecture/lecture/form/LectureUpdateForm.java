package com.steveleeacademy.academylecture.lecture.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.steveleeacademy.academylecture.lecture.domain.LectureStatus;
import com.steveleeacademy.academylecture.lecture.domain.RegistStatus;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Getter
public class LectureUpdateForm {

    private Long id;

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
