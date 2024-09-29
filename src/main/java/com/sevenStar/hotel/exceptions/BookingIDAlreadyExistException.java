package com.sevenStar.hotel.exceptions;

public class BookingIDAlreadyExistException extends RuntimeException {
    public BookingIDAlreadyExistException(String message) {
        super(message);
    }
}
