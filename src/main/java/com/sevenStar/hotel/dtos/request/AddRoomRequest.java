package com.sevenStar.hotel.dtos.request;

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
    private String roomType;
    private int roomNumber;
}
