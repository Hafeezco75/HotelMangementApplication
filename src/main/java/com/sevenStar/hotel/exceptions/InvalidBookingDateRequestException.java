package com.sevenStar.hotel.exceptions;

public class InvalidBookingDateRequestException extends RuntimeException {
    public InvalidBookingDateRequestException(String message) {
        super(message);
    }
}
