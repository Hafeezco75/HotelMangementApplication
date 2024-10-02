package com.sevenStar.hotel.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class AddRoomRequest {
    private boolean roomAvailable = true;
    private BigDecimal roomPrice;
    private String description;
    private String roomImage;
    private String roomType;
    private int roomNumber;
}
