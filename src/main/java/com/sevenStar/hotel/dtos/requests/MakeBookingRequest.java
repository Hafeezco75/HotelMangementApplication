package com.sevenStar.hotel.dtos.requests;

import com.sevenStar.hotel.enums.RoomTypes;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

public class MakeBookingRequest {
    private String email;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private RoomTypes roomType;
    private String paymentMethod;



}
