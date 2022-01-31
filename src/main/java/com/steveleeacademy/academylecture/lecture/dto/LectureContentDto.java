package com.steveleeacademy.academylecture.lecture.dto;

import com.steveleeacademy.academylecture.lecture.domain.Lecture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LectureContentDto {

    private Long id;
    private String title;
    private String writer;

    public static List<LectureContentDto> createLectureListDto(List<Lecture> lectures) {
        List<LectureContentDto> lectureContentDtos = new ArrayList<>();
        lectures.forEach(lecture -> {
            lectureContentDtos.add(LectureContentDto.builder()
                    .id(lecture.getId())
                    .title(lecture.getTitle())
                    .writer(lecture.getWriter())
                    .build());
        });

        return lectureContentDtos;
    }
}
