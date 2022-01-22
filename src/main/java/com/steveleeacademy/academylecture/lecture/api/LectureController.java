package com.steveleeacademy.academylecture.lecture.api;

import com.steveleeacademy.academylecture.lecture.dto.LectureCreateDto;
import com.sun.xml.bind.v2.TODO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.nio.charset.Charset;
import java.util.*;

@RestController
@Slf4j
public class LectureController {

    /**
     * 강의목록
     */
    @GetMapping("/")
    public ResponseEntity getLectures() {
//        HashMap<String, String> header = new HashMap<>();
//        header.put("resultCode", "ok");
//        header.put("resultMesg", "test");
//
//        List<String> headers = new ArrayList<>(header.keySet());

        HttpHeaders headers= new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        return new ResponseEntity("test", headers, HttpStatus.OK);
    }

    /**
     * 강의상세보기
     */
    @GetMapping("/lectureDetail")
    public void lectureDetail() {

    }

    /**
     * 강의생성
     * 강의 시퀀스 리턴?
     */
    // TODO : 강의 생성부터 우선적으로 실행되어야 함
    @PostMapping("/createLecture")
    @Valid
    public ResponseEntity<String> createLecture(@Valid LectureCreateDto lectureCreateDto) {
        log.info("createLecture info : {}", lectureCreateDto);

        return ResponseEntity.ok().body("강의 생성 성공");
    }

    /**
     * 필터처리
     */

}
