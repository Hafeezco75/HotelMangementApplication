package com.sevenStar.hotel.dtos.requests;

import com.sevenStar.hotel.models.entities.Room;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBookingRequest {
    private Long bookingID;
    private Room room;
    private String roomType;
}
