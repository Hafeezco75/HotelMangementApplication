package com.sevenStar.hotel.dtos.request;

import com.sevenStar.hotel.enums.RoomTypes;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class UpdateRoomRequest {
    private String name;
    private boolean isAvailable;
    private BigDecimal price;
    private String description;
    private String image;
    private RoomTypes type;
    private int OldRoomNumber;
    private int NewRoomNumber;
}
