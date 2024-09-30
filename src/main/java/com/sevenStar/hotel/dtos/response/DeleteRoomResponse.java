package com.sevenStar.hotel.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeleteRoomResponse {

    private int roomNumber;
    private Long roomId;
    private String message;
}
