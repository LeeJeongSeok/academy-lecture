package com.steveleeacademy.academylecture.lecture.service;

import com.steveleeacademy.academylecture.lecture.domain.Category;
import com.steveleeacademy.academylecture.lecture.domain.Day;
import com.steveleeacademy.academylecture.lecture.domain.Keyword;
import com.steveleeacademy.academylecture.lecture.domain.Lecture;
import com.steveleeacademy.academylecture.lecture.dto.LectureContentDto;
import com.steveleeacademy.academylecture.lecture.dto.LectureDetailDto;
import com.steveleeacademy.academylecture.lecture.dto.LectureListDto;
import com.steveleeacademy.academylecture.lecture.form.LectureCreateForm;
import com.steveleeacademy.academylecture.lecture.form.LectureUpdateForm;
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
@Transactional
@RequiredArgsConstructor
public class LectureService {

    private final LectureRepository lectureRepository;
    private final CategoryRepository categoryRepository;
    private final DayRepository dayRepository;;
    private final KeywordRepository keywordRepository;

    /**
     * 강의 생성
     */
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

        return lectureRepository.save(lecture).getId();
    }

    /**
     * 강의 리스트
     */
    public LectureListDto findLectures() {
        List<Lecture> lectures = lectureRepository.findAll();

        return new LectureListDto(LectureContentDto.createLectureListDto(lectures));
    }

    /**
     * 강의 상세보기
     */
    public LectureDetailDto findLecture(Long lectureId) {
        return LectureDetailDto.createLectureDetailDto(lectureRepository.findById(lectureId).get());
    }

    /**
     * 강의 수정
     */
    public Long updateLecture(LectureUpdateForm lectureUpdateForm) {

        if (lectureUpdateForm.getId() != null) {

            deleteForeignData(lectureUpdateForm);

            Lecture updateLecture = Lecture.updateLectureBuilder(lectureUpdateForm);

            lectureUpdateForm.getCategories().forEach(category -> {
                updateLecture.addCategory(new Category(category));
            });

            lectureUpdateForm.getDays().forEach(day -> {
                updateLecture.addDay(new Day(day));
            });

            lectureUpdateForm.getKeywords().forEach(keyword -> {
                updateLecture.addKeyword(new Keyword(keyword));
            });

            return lectureRepository.save(updateLecture).getId();
        } else {
            throw new IllegalArgumentException("수정할 강의 ID값이 존재하지 않습니다.");
        }
    }

    private void deleteForeignData(LectureUpdateForm lectureUpdateForm) {
        lectureRepository.findById(lectureUpdateForm.getId()).get().getCategories().forEach(category -> {
            categoryRepository.deleteById(category.getId());
        });

        lectureRepository.findById(lectureUpdateForm.getId()).get().getDays().forEach(day -> {
            dayRepository.deleteById(day.getId());
        });

        lectureRepository.findById(lectureUpdateForm.getId()).get().getKeywords().forEach(keyword -> {
            keywordRepository.deleteById(keyword.getId());
        });
    }

    /**
     * 필터 조건으로 강의 찾기
     */

    /**
     * 강의 신청
     */


}
