package com.sevenStar.hotel.enums;

import lombok.experimental.FieldNameConstants;

@FieldNameConstants(onlyExplicitlyIncluded = true)
public enum RoomTypes {
        @FieldNameConstants.Include DUPLEX,
        @FieldNameConstants.Include VIP,
        @FieldNameConstants.Include EXECUTIVE,
        @FieldNameConstants.Include DELUXE,
        @FieldNameConstants.Include STANDARD;


}
