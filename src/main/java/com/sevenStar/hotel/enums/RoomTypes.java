package com.sevenStar.hotel.enums;

import com.sevenStar.hotel.exceptions.InvalidRoomTypeError;
import lombok.experimental.FieldNameConstants;

import java.util.Arrays;

@FieldNameConstants(onlyExplicitlyIncluded = true)
public enum RoomTypes {
        @FieldNameConstants.Include DUPLEX,
        @FieldNameConstants.Include VIP,
        @FieldNameConstants.Include EXECUTIVE,
        @FieldNameConstants.Include DELUXE,
        @FieldNameConstants.Include STANDARD;



    public static RoomTypes fromString(String roomType) {
        try {
            return RoomTypes.valueOf(roomType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidRoomTypeError("Invalid room type: " + roomType + "\n" + "Valid options are: " + Arrays.toString(validValues()));
        }
    }

    public static RoomTypes[] validValues() {
        return  RoomTypes.values();
    }
}
