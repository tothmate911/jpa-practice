package com.codecool.jpapractice.repository;

import com.codecool.jpapractice.entity.Season;
import com.codecool.jpapractice.entity.Series;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
class SeriesRepositoryTest {

    @Autowired
    SeriesRepository seriesRepository;

    @Autowired
    SeasonRepository seasonRepository;

    @Test
    public void seasonsArePersistentWithSeries() {
        Season season1 = Season.builder()
                .title("Season1")
                .build();

        Season season2 = Season.builder()
                .title("Season2")
                .build();

        Series series = Series.builder()
                .title("Series")
                .season(season1)
                .season(season2)
                .build();

        seriesRepository.save(series);

        List<Season> seasonList = seasonRepository.findAll();
        assertThat(seasonList)
                .hasSize(2)
                .allMatch(season -> season.getId() > 0L);
    }

}