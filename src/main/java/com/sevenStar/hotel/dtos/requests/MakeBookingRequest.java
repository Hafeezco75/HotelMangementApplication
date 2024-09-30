package com.sevenStar.hotel.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class MakeBookingRequest {
    private String email;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String roomType;
    private String paymentMethod;



}
