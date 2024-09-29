package com.sevenStar.hotel.dtos.requests;

import com.sevenStar.hotel.models.entities.Room;
import com.sevenStar.hotel.enums.RoomTypes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetBookingRequest {
    private Long bookingID;
    private Room room;
    private RoomTypes roomType;
}
