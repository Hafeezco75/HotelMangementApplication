package com.sevenStar.hotel.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.sevenStar.hotel.enums.RoomTypes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddRoomResponse {
    private Long roomId;
    private boolean roomAvailable;
    private BigDecimal roomPrice;
    private String description;
    private String roomImage;
    private String roomType;
    private String message;
    private int roomNumber;


}