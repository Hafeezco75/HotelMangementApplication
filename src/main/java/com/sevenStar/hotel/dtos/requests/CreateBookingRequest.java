package com.sevenStar.hotel.dtos.requests;

import com.sevenStar.hotel.enums.UserRoles;
import com.sevenStar.hotel.models.entities.Room;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateBookingRequest {
    private LocalDate checkIn;
    private LocalDate checkOut;
    @ManyToOne
    private Room room;
    private Long userId;
    private String paymentMethod;

}
