package com.sevenStar.hotel.exceptions;

public class BookingInformationExistException extends RuntimeException {
    public BookingInformationExistException(String message) {
        super(message);
    }

}
