package com.sevenStar.hotel.dtos.response;

import com.sevenStar.hotel.models.entities.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewBookingsResponse {
    private Booking booking;
    private String message;
}
