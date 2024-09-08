package com.BookMyShow.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "show_seat")
public class ShowSeat extends Seat{

    @ManyToOne(fetch = FetchType.EAGER)
    private Shows show;
    private Boolean isActive;
}
