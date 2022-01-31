package com.steveleeacademy.academylecture.lecture.api;

import com.steveleeacademy.academylecture.lecture.dto.LectureCreateDto;
import com.steveleeacademy.academylecture.lecture.dto.LectureDetailDto;
import com.steveleeacademy.academylecture.lecture.dto.LectureListDto;
import com.steveleeacademy.academylecture.lecture.form.LectureCreateForm;
import com.steveleeacademy.academylecture.lecture.service.LectureService;
import com.sun.xml.bind.v2.TODO;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.charset.Charset;
import java.util.*;

@CrossOrigin
@Api(tags = "오프라인 클래스 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Slf4j
public class LectureController {

    private final LectureService lectureService;

    /**
     * 강의 리스트
     */
    @GetMapping("/")
    public ResponseEntity<LectureListDto> getLectures() {
        return ResponseEntity.ok(lectureService.findLectures());
    }

    /**
     * 강의상세보기
     */
    @GetMapping("/lectureDetail/{lectureId}")
    public ResponseEntity<LectureDetailDto> lectureDetail(@PathVariable Long lectureId) {
        return ResponseEntity.ok(lectureService.findLecture(lectureId));
    }

    /**
     * 강의생성
     * 강의 시퀀스 리턴?
     */
    // TODO : 강의 생성부터 우선적으로 실행되어야 함
    @PostMapping("/createLecture")
    public ResponseEntity<String> createLecture(@RequestBody LectureCreateForm lectureCreateForm) {
        log.info("createLecture info : {}", lectureCreateForm);

        lectureService.createLecture(lectureCreateForm);

        return ResponseEntity.ok().body("강의 생성 성공");
    }

    /**
     * 필터처리
     */

}
