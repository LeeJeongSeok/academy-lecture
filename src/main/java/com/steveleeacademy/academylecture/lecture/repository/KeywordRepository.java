package com.steveleeacademy.academylecture.lecture.repository;

import com.steveleeacademy.academylecture.lecture.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {
}
