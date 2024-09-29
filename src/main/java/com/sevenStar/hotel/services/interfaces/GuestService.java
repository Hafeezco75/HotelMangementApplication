package com.sevenStar.hotel.services.interfaces;

import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.responses.*;

public interface GuestService {

    RegisterGuestResponse registerGuest(RegisterGuestRequest registerGuestRequest);

    LoginGuestResponse loginGuest(LoginGuestRequest loginGuestRequest);

    UpdateGuestResponse updateGuest(UpdateGuestRequest updateGuestRequest);

    DeleteGuestResponse deleteGuest(DeleteGuestRequest deleteGuestRequest);

    MakeBookingResponse makeBooking(MakeBookingRequest makeBookingRequest);

    ViewBookingsResponse viewBookings(ViewBookingsRequest viewBookingsRequest);

    CancelBookingResponse cancelBooking(long id);





}
