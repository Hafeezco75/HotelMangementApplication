package com.sevenStar.hotel.dtos.requests;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class UpdateRoomRequest {
    private Long roomId;
    private String name;
    private int roomNumber;
    private boolean isAvailable;
    private BigDecimal price;
    private String description;
    private String image;
    private String type;
    private int OldRoomNumber;
    private int NewRoomNumber;
}
