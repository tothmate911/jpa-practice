package com.codecool.jpapractice.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {

    @Id
    @GeneratedValue
    Long id;

    private String title;

    private LocalDate releaseDate;

    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @Singular
    private List<Episode> episodes;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Series series;
}
