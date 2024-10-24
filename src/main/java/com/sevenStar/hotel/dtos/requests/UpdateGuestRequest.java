package com.sevenStar.hotel.dtos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class UpdateGuestRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String password;
}
