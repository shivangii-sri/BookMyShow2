package com.BookMyShow.entities;

import com.BookMyShow.entities.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User extends BaseEntity {

    private String name;

    @OneToOne(cascade = CascadeType.ALL , orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore  // Ignoring the location during serialization
    private Location location;
    private String email;
    private String phone;


    //Will unComment when we make booking class.
//    @OneToMany(cascade = CascadeType.ALL , orphanRemoval = true, mappedBy = "person")
//    private List<Booking> booking;
}
