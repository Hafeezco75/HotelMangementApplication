package com.sevenStar.hotel.models.entities;

import com.sevenStar.hotel.enums.RoomTypes;
import com.sevenStar.hotel.enums.UserRoles;
import jakarta.annotation.Nonnull;
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
<<<<<<< HEAD
    private Long bookingID;
    private LocalDate checkIn;
    private LocalDate checkOut;
    @JoinColumn(nullable = false)
    @ManyToOne(cascade = CascadeType.ALL)
    private Room room;
    @Enumerated(EnumType.STRING)
    private UserRoles userRole;
    @Enumerated(EnumType.STRING)
    private RoomTypes roomType;
=======
    private int bookingID;

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String roomType;
    private String paymentMethod;

//    @ManyToOne
//    private Room room;
>>>>>>> b144de605ce8a8e38e11ff12337c1d1a5e29a8b7
}
