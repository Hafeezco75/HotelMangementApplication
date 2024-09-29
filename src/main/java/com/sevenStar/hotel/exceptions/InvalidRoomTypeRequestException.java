package com.sevenStar.hotel.exceptions;

public class InvalidRoomTypeRequestException extends RuntimeException {
    public InvalidRoomTypeRequestException(String message) {
        super(message);
    }
}
