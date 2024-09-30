package com.sevenStar.hotel.dtos.response;

import com.sevenStar.hotel.dtos.responses.RegisterGuestResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
    boolean success;
    private String message;


}
