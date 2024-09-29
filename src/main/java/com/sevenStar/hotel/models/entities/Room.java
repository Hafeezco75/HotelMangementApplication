package com.sevenStar.hotel.models.entities;

import com.sevenStar.hotel.enums.RoomTypes;
import jakarta.annotation.Nonnull;
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
    @Nonnull
    private String roomName;
    private BigDecimal roomPrice;
    private boolean roomAvailable;
    @Nonnull
    private String description;
    private String roomImage;
    @Enumerated(EnumType.STRING)
    private RoomTypes roomType;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Booking> bookings;

}
