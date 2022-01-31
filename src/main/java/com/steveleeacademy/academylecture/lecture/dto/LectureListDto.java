package com.steveleeacademy.academylecture.lecture.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LectureListDto {

    private List<LectureContentDto> lectures;
}
