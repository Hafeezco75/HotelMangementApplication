package com.sevenStar.hotel.enums;

import lombok.experimental.FieldNameConstants;

@FieldNameConstants(onlyExplicitlyIncluded = true)
public enum UserRoles {
    @FieldNameConstants.Include ADMIN,
    @FieldNameConstants.Include GUEST,

}
