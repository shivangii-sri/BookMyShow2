package com.BookMyShow.entities;

import com.BookMyShow.entities.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "theatre")
public class Theatre extends BaseEntity {

    private String name;

    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true)
    private Location location;

    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Hall> hall;
}
