package com.codecool.jpapractice.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {

    @Id
    @GeneratedValue
    Long id;

    private String title;

    @OneToMany(cascade = CascadeType.PERSIST)
    @Singular
    private List<Season> seasons;

    @ElementCollection
    @Singular
    private Set<String> actors;

    @Enumerated(EnumType.STRING)
    private Genre genre;

}
