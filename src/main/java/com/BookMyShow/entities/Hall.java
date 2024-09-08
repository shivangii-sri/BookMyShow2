package com.BookMyShow.entities;

import com.BookMyShow.entities.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "hall")
public class Hall extends BaseEntity {

    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)// cascade = CascadeType.ALL
    private Theatre theatre;

    @OneToMany(mappedBy = "hall")
    private List<HallSeat> hallSeats;

    @OneToMany(mappedBy = "hall")
    private List<Shows> shows;
}
