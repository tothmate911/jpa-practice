package com.codecool.jpapractice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private Season season;


}
