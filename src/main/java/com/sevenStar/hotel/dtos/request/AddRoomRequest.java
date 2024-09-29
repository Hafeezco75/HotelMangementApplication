package com.sevenStar.hotel.dtos.request;

import com.sevenStar.hotel.enums.RoomTypes;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AddRoomRequest {
    private String roomName;
    private boolean roomAvailable = true;
    private BigDecimal roomPrice;
    private String description;
    private String roomImage;
    private RoomTypes roomType;
    private int roomNumber;
}
