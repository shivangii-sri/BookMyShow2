package com.BookMyShow.entities;

import com.BookMyShow.entities.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "shows")
public class Shows extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    private Theatre theatre;

    @ManyToOne(fetch = FetchType.LAZY)
    private Hall hall;

    @OneToMany(mappedBy = "show")
    private List<ShowSeat> showSeat;

    private Date startTime;
    private Date endTime;
    private Date date;
}
