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
public class UpdateRoomResponse {

    private Long roomId;
    private boolean isAvailable;
    private BigDecimal price;
    private String description;
    private String image;
    private String type;
    private int roomNumber;
}
