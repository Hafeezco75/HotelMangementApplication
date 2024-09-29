package com.sevenStar.hotel.dtos.request;

import com.sevenStar.hotel.enums.RoomTypes;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class UpdateRoomRequest {
    private Long id;
    private boolean isAvailable;
    private BigDecimal price;
    private String description;
    private String image;
    private String type;
    private int roomNumber;
}
