package com.sevenStar.hotel.dtos.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.sevenStar.hotel.models.entities.Room;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReviewAllResponse {
    private List<Room> rooms;
    private String message;
}
