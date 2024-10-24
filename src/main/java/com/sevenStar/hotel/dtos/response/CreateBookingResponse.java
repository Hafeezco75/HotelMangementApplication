package com.sevenStar.hotel.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class CreateBookingResponse {
    private Long bookingID;
    private String message;

}
