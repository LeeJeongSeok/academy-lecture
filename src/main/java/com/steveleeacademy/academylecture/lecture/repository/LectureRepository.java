package com.steveleeacademy.academylecture.lecture.repository;

import com.steveleeacademy.academylecture.lecture.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
