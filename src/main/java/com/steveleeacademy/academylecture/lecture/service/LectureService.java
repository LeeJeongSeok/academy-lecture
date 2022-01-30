package com.steveleeacademy.academylecture.lecture.service;

import com.steveleeacademy.academylecture.lecture.domain.Category;
import com.steveleeacademy.academylecture.lecture.domain.Keyword;
import com.steveleeacademy.academylecture.lecture.domain.Lecture;
import com.steveleeacademy.academylecture.lecture.form.LectureCreateForm;
import com.steveleeacademy.academylecture.lecture.repository.CategoryRepository;
import com.steveleeacademy.academylecture.lecture.repository.DayRepository;
import com.steveleeacademy.academylecture.lecture.repository.KeywordRepository;
import com.steveleeacademy.academylecture.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final CategoryRepository categoryRepository;
    private final DayRepository dayRepository;
    private final KeywordRepository keywordRepository;

    // 강의 생성

    // 강의 리스트

    // 강의 상세보기

    // 필터 조건으로 강의 찾기

    // 강의 신청?

    /**
     * 강의 생성
     */
    @Transactional
    public Long createLecture(LectureCreateForm lectureCreateForm) {

        Lecture lecture = lectureRepository.save(Lecture.createLectureBuilder(lectureCreateForm));

        List<String> categories = lectureCreateForm.getCategories();
        List<String> keywords = lectureCreateForm.getKeywords();
        List<String> days = lectureCreateForm.getDays();

        lectureCreateForm.getCategories().forEach(category -> {
            lecture.addCategory(new Category(category));
        });

        for (String category : categories) {
            log.info("category : {}", category);
        }

        for (String keyword : keywords) {
            log.info("keyword : {}", keyword);
        }

        for (String day : days) {
            log.info("day : {}", day);
        }

        return lecture.getId();
    }

}
