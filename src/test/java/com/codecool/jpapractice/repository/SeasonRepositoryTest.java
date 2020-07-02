package com.codecool.jpapractice.repository;

import com.codecool.jpapractice.entity.Episode;
import com.codecool.jpapractice.entity.Season;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class SeasonRepositoryTest {

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Test
    public void episodeIsPersistentWithSeason() {
        Episode episode = Episode.builder()
                .title("episode")
                .lengthInMinutes(120)
                .build();

        Season season = Season.builder()
                .episode(episode)
                .build();

        seasonRepository.save(season);

        List<Episode> episodeList = episodeRepository.findAll();
        assertThat(episodeList)
                .hasSize(1)
                .allMatch(episode1 -> episode1.getId() > 0L);
    }

}
