package com.steveleeacademy.academylecture.lecture.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LectureController {

    /**
     * 강의목록
     */
    @GetMapping("/")
    public ResponseEntity getLectures() {
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * 강의상세보기
     */
    public void lectureDetail() {

    }

    /**
     * 강의생성
     */
    public void createLecture() {

    }

    /**
     * 필터처리
     */

}
