package com.sevenStar.hotel.models.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomId;
    private BigDecimal roomPrice;
    private boolean roomAvailable;
    private String description;
    private String roomImage;
    private String roomType;
    private int roomNumber;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> bookings;

}
