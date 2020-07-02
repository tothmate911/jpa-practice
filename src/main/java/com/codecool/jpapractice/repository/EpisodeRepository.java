package com.codecool.jpapractice.repository;

import com.codecool.jpapractice.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
