package com.sevenStar.hotel.exceptions;

public class GuestAlreadyExistException extends RuntimeException {
    public GuestAlreadyExistException(String message) {
        super(message);
    }
}
