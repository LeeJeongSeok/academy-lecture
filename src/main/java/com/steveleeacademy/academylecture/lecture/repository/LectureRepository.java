package com.steveleeacademy.academylecture.lecture.repository;

import com.steveleeacademy.academylecture.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    @Query("select l from Lecture l where l.title like %:title% and l.writer like %:writer%")
    List<Lecture> searchingLecture(@Param("title") String title, @Param("writer") String writer);

    @Query("select l from Lecture l where l.categories = :category and l.title like %:title% and l.writer like %:writer%")
    List<Lecture> searchingLectureWithCategory(@Param("category") String category, @Param("title") String title, @Param("writer") String writer);
}
