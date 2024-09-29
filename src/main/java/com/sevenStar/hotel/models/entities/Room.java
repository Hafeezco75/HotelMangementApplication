package com.sevenStar.hotel.models.entities;

import com.sevenStar.hotel.enums.RoomTypes;
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

    private String roomName;

    private BigDecimal roomPrice;

    private boolean roomAvailable;

    private String description;

    private String roomImage;

    @Enumerated(EnumType.STRING)
    private RoomTypes roomType;
//    remember to validate your enum to throw wrong room type error when you set wrong type wey no dey the enum class

    private int roomNumber;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Booking> bookings;

}
