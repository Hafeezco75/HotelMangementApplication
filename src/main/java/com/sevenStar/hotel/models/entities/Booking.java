package com.sevenStar.hotel.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;

    private LocalDate checkIn;
    private LocalDate checkOut;

    @ManyToOne
    private Room room;
}
