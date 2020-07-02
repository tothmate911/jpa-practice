package com.codecool.jpapractice.repository;

import com.codecool.jpapractice.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
