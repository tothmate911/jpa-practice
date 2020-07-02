package com.codecool.jpapractice.repository;

import com.codecool.jpapractice.entity.Episode;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class EpisodeRepositoryTest {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void saveOneSimple() {
        Episode episode = Episode.builder()
                .title("episode")
                .lengthInMinutes(120)
                .build();

        episodeRepository.save(episode);

        List<Episode> episodeList = episodeRepository.findAll();
        assertThat(episodeList).hasSize(1);
    }

    @Test
    public void transientShouldNotBeSaved() {
        Episode episode = Episode.builder()
                .title("episode")
                .lengthInMinutes(120)
                .build();
        episode.calculateLengthInHours();

        episodeRepository.save(episode);
        entityManager.clear();

        List<Episode> episodeList = episodeRepository.findAll();
        assertThat(episodeList).allMatch(episode1 -> episode1.getLengthInHours() == 0F);
    }

}
