package com.sevenStar.hotel.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class DeleteGuestRequest {
    private String email;
    private String password;
}
