package com.sevenStar.hotel.dtos.requests;

import com.sevenStar.hotel.models.entities.Room;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateBookingRequest {
    private Long bookingID;
    private LocalDate checkIn;
    private LocalDate checkOut;
    @ManyToOne
    private Room room;
}
