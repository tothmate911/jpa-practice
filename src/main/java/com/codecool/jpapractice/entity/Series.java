package com.codecool.jpapractice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Series {

    @Id
    @GeneratedValue
    Long id;

    private String title;

    @OneToMany
    private List<Season> seasons;

    @ElementCollection
    @Singular
    private Set<String> actors;

    @Enumerated(EnumType.STRING)
    private Genre genre;

}
