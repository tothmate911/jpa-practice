package com.codecool.jpapractice.entity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {

    @Id
    @GeneratedValue
    Long id;

    private String title;

    private Integer lengthInMinutes;

    @Transient
    private Float lengthInHours;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Season season;

    public void calculateLengthInHours() {
        lengthInHours = (float) lengthInMinutes / 60;
    }

}
