package com.sevenStar.hotel.exceptions;

public class InvalidCheckInDateException extends RuntimeException {
    public InvalidCheckInDateException(String message) {
        super(message);
    }
}
