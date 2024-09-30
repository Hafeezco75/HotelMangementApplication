package com.sevenStar.hotel.dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UpdateBookingResponse {
    private Long bookingID;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String message;

}
