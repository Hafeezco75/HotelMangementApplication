package com.sevenStar.hotel.dtos.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DeleteBookingResponse {
    private Long bookingID;
    private String message;
    private boolean bookingStatus;
}
