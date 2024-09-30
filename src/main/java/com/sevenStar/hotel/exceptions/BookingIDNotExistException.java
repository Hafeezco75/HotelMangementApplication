package com.sevenStar.hotel.exceptions;

public class BookingIDNotExistException extends RuntimeException {
    public BookingIDNotExistException(String message) {
        super(message);
    }
}
