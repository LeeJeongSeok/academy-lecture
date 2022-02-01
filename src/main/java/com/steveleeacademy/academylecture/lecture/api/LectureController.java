package com.steveleeacademy.academylecture.lecture.api;

import com.steveleeacademy.academylecture.lecture.dto.LectureDetailDto;
import com.steveleeacademy.academylecture.lecture.dto.LectureListDto;
import com.steveleeacademy.academylecture.lecture.form.LectureCreateForm;
import com.steveleeacademy.academylecture.lecture.form.LectureUpdateForm;
import com.steveleeacademy.academylecture.lecture.service.LectureService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "오프라인 클래스 API")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v1")
@Slf4j
public class LectureController {

    private final LectureService lectureService;

    /**
     * 강의 리스트
     */
    @GetMapping("/lecture")
    public ResponseEntity<LectureListDto> getLectures() {
        return ResponseEntity.ok(lectureService.findLectures());
    }

    /**
     * 강의상세보기
     */
    @GetMapping("/lecture/{id}")
    public ResponseEntity<LectureDetailDto> getLecture(@PathVariable Long id) {
        return ResponseEntity.ok(lectureService.findLecture(id));
    }

    /**
     * 강의생성
     * 강의 시퀀스 리턴?
     */
    @PostMapping("/lecture")
    public ResponseEntity<Long> createLecture(@Valid @RequestBody LectureCreateForm lectureCreateForm) {
        log.info("### Lecture Create Form : {}", lectureCreateForm);
        return ResponseEntity.ok(lectureService.createLecture(lectureCreateForm));
    }

    /**
     * 강의 수정
     */
    @PutMapping("/lecture")
    public ResponseEntity<Long> updateLecture(@Valid @RequestBody LectureUpdateForm lectureUpdateForm) {
        log.info("### Lecture Update Form : {}", lectureUpdateForm.getId());
        return ResponseEntity.ok(lectureService.updateLecture(lectureUpdateForm));
    }

    /**
     * 필터처리
     */

}
