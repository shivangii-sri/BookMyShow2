package com.BookMyShow.entities;

import com.BookMyShow.entities.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "movie")
public class Movie extends BaseEntity {

    private String movieName;
    private int duration;
    private boolean isActive;
    //private List<String> genre;
}
