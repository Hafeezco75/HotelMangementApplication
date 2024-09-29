package com.sevenStar.hotel.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import com.sevenStar.hotel.enums.RoomTypes;
import com.sevenStar.hotel.models.entities.Room;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomDTO {

    private Long roomId;
    private String roomName;
    private boolean roomAvailable;
    private BigDecimal roomPrice;
    private String description;
    private String roomImage;
    private RoomTypes roomType;
    private List<Room> rooms;
    private String message;
    private int roomNumber;
    private Room foundRoom;

}