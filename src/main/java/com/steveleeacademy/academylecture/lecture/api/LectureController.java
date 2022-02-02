package com.steveleeacademy.academylecture.lecture.api;

import com.steveleeacademy.academylecture.lecture.dto.LectureContentDto;
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
import java.util.List;

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
     * 검색명 & 카테고리로 찾기
     */
    @GetMapping("/lecture/search")
    public ResponseEntity<List<LectureContentDto>> searchLecture(@RequestParam String category, @RequestParam String title, @RequestParam String writer) {
        log.info("### Search Category  : {}", category);
        log.info("### Search Title : {}", title);
        log.info("### Search Writer : {}", writer);

        return ResponseEntity.ok(lectureService.searchLecture(category, title, writer));
    }

//    /**
//     * 강좌 신청
//     */
//    @PostMapping("/lecture/application")
//    public ResponseEntity<String> lectureApplication(@RequestParam String userId, @RequestParam String lectureId) {
//        log.info("### User ID : {}", userId);
//        log.info("### Lecture ID : {}", lectureId);
//
//        lectureService.lectureApplication(userId, lectureId);
//
//        return ResponseEntity.ok("강의 신청 성공");
//    }

    /**
     * 강좌 신청 내역
     */
}
