package com.BookMyShow.entities;

import com.BookMyShow.entities.common.BaseEntity;
import com.BookMyShow.enums.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Data //Lombok generates getters for all non-static fields, setters for all non-final fields in the class.
@NoArgsConstructor
@MappedSuperclass//to have no Direct Table Mapping, child classed inheriting this entity will have below fields in their tables.
@Access(AccessType.FIELD) //JPA directly accesses the fields of this entity, bypassing any getter/setter methods that may exist
@EntityListeners(AuditingEntityListener.class)
public class Seat extends BaseEntity {

    private String seatNumber;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Hall hall;

    private SeatType seatType;
}
