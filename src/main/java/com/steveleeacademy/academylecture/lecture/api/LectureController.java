package com.steveleeacademy.academylecture.lecture.api;

import com.steveleeacademy.academylecture.lecture.dto.LectureContentDto;
import com.steveleeacademy.academylecture.lecture.dto.LectureDetailDto;
import com.steveleeacademy.academylecture.lecture.dto.LectureListDto;
import com.steveleeacademy.academylecture.lecture.form.LectureCreateForm;
import com.steveleeacademy.academylecture.lecture.form.LectureUpdateForm;
import com.steveleeacademy.academylecture.lecture.service.LectureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "강의목록", notes = "강의목록을 출력한다.")
    public ResponseEntity<LectureListDto> getLectures() {
        return ResponseEntity.ok(lectureService.findLectures());
    }

    /**
     * 강의상세보기
     */
    @GetMapping("/lecture/{id}")
    @ApiOperation(value = "상세보기", notes = "강의의 대한 내용을 출력한다.")
    public ResponseEntity<LectureDetailDto> getLecture(@PathVariable Long id) {
        return ResponseEntity.ok(lectureService.findLecture(id));
    }

    /**
     * 강의생성
     */
    @PostMapping("/lecture")
    @ApiOperation(value = "강의생성", notes = "강의를 생성한다.")
    public ResponseEntity<Long> createLecture(@Valid @RequestBody LectureCreateForm lectureCreateForm) {
        log.info("### Lecture Create Form : {}", lectureCreateForm);
        return ResponseEntity.ok(lectureService.createLecture(lectureCreateForm));
    }

    /**
     * 강의 수정
     */
    @PutMapping("/lecture")
    @ApiOperation(value = "강의수정", notes = "강의를 수정한다.")
    public ResponseEntity<Long> updateLecture(@Valid @RequestBody LectureUpdateForm lectureUpdateForm) {
        log.info("### Lecture Update Form : {}", lectureUpdateForm.getId());
        return ResponseEntity.ok(lectureService.updateLecture(lectureUpdateForm));
    }

    /**
     * 검색명 & 카테고리로 찾기
     */
    @GetMapping("/lecture/search")
    @ApiOperation(value = "강의 찾기", notes = "주어진 검색어, 카테고리로 강의를 찾는다.")
    public ResponseEntity<List<LectureContentDto>> searchLecture(@RequestParam String category, @RequestParam String title, @RequestParam String writer) {
        log.info("### Search Category  : {}", category);
        log.info("### Search Title : {}", title);
        log.info("### Search Writer : {}", writer);

        return ResponseEntity.ok(lectureService.searchLecture(category, title, writer));
    }
}
