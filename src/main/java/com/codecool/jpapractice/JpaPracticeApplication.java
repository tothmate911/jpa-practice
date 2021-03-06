package com.codecool.jpapractice;

import com.codecool.jpapractice.entity.Episode;
import com.codecool.jpapractice.entity.Genre;
import com.codecool.jpapractice.entity.Season;
import com.codecool.jpapractice.entity.Series;
import com.codecool.jpapractice.repository.EpisodeRepository;
import com.codecool.jpapractice.repository.SeasonRepository;
import com.codecool.jpapractice.repository.SeriesRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import java.time.LocalDate;

@SpringBootApplication
public class JpaPracticeApplication {

    private SeriesRepository seriesRepository;
    private EpisodeRepository episodeRepository;
    private SeasonRepository seasonRepository;

    @Autowired
    EntityManager entityManager;

    public JpaPracticeApplication(SeriesRepository seriesRepository, EpisodeRepository episodeRepository, SeasonRepository seasonRepository) {
        this.seriesRepository = seriesRepository;
        this.episodeRepository = episodeRepository;
        this.seasonRepository = seasonRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaPracticeApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Episode episode1 = Episode.builder()
                    .title("episode1")
                    .lengthInMinutes(120)
                    .build();
            episode1.calculateLengthInHours();

//            episodeRepository.save(episode1);

            Episode episode2 = Episode.builder()
                    .title("episode2")
                    .lengthInMinutes(180)
                    .build();

            Episode episode3 = Episode.builder()
                    .title("episode3")
                    .lengthInMinutes(100)
                    .build();

            Season season1 = Season.builder()
                    .releaseDate(LocalDate.of(1990, 10, 1))
                    .title("season1")
                    .episode(episode1)
                    .build();

            episode1.setSeason(season1);

            Season season2 = Season.builder()
                    .releaseDate(LocalDate.of(1990, 10, 1))
                    .title("season2")
                    .episodes(Lists.newArrayList(episode2, episode3))
                    .build();

            episode2.setSeason(season2);
            episode3.setSeason(season2);

//            seasonRepository.saveAll(Lists.newArrayList(season1, season2));

            Series series = Series.builder()
                    .title("The Earth")
                    .actor("Joe Average")
                    .actor("James")
                    .seasons(Lists.newArrayList(season1, season2))
                    .genre(Genre.DOCUMENTARY)
                    .build();

            season1.setSeries(series);
            season2.setSeries(series);

            seriesRepository.save(series);
            System.out.println(series);

        };
    }
}
