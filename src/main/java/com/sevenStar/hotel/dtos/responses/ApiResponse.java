package com.sevenStar.hotel.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    boolean success;
    Object message;
}
