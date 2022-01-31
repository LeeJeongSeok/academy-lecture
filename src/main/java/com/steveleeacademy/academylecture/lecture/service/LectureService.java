package com.steveleeacademy.academylecture.lecture.service;

import com.steveleeacademy.academylecture.lecture.domain.Category;
import com.steveleeacademy.academylecture.lecture.domain.Day;
import com.steveleeacademy.academylecture.lecture.domain.Keyword;
import com.steveleeacademy.academylecture.lecture.domain.Lecture;
import com.steveleeacademy.academylecture.lecture.dto.LectureDetailDto;
import com.steveleeacademy.academylecture.lecture.dto.LectureListDto;
import com.steveleeacademy.academylecture.lecture.form.LectureCreateForm;
import com.steveleeacademy.academylecture.lecture.repository.CategoryRepository;
import com.steveleeacademy.academylecture.lecture.repository.DayRepository;
import com.steveleeacademy.academylecture.lecture.repository.KeywordRepository;
import com.steveleeacademy.academylecture.lecture.repository.LectureRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final CategoryRepository categoryRepository;
    private final DayRepository dayRepository;
    private final KeywordRepository keywordRepository;

    // 필터 조건으로 강의 찾기

    // 강의 신청?

    /**
     * 강의 생성
     */
    @Transactional
    public Long createLecture(LectureCreateForm lectureCreateForm) {

        Lecture lecture = lectureRepository.save(Lecture.createLectureBuilder(lectureCreateForm));

        lectureCreateForm.getCategories().forEach(category -> {
            lecture.addCategory(new Category(category));
        });

        lectureCreateForm.getDays().forEach(day -> {
            lecture.addDay(new Day(day));
        });

        lectureCreateForm.getKeywords().forEach(keyword -> {
            lecture.addKeyword(new Keyword(keyword));
        });

        return lecture.getId();
    }

    /**
     * 강의 리스트
     */
    public LectureListDto findLectures() {

        return new LectureListDto();
    }

    /**
     * 강의 상세보기
     */
    public LectureDetailDto findLecture(Long lectureId) {
        return LectureDetailDto.createLectureDetailDto(lectureRepository.findById(lectureId).get());
    }


}
