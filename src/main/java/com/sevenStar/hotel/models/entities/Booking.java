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

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String roomType;
    private String paymentMethod;

//    @ManyToOne
//    private Room room;
}
