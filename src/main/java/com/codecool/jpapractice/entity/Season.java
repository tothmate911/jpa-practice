package com.codecool.jpapractice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Season {

    @Id
    @GeneratedValue
    Long id;

    private String title;

    private LocalDate releaseDate;

    @OneToMany
    private List<Episode> episodes;

    @ManyToOne
    private Series series;
}
