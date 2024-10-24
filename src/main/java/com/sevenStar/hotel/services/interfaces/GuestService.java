package com.sevenStar.hotel.services.interfaces;

import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.responses.*;
import com.sevenStar.hotel.models.entities.Booking;

import java.util.List;

public interface GuestService {

    RegisterGuestResponse registerGuest(RegisterGuestRequest registerGuestRequest);

    LoginGuestResponse loginGuest(LoginGuestRequest loginGuestRequest);

    UpdateGuestResponse updateGuest(UpdateGuestRequest updateGuestRequest);

    DeleteGuestResponse deleteGuest(DeleteGuestRequest deleteGuestRequest);

    MakeBookingResponse makeBooking(MakeBookingRequest makeBookingRequest);

//    Booking viewBookings(ViewBookingsRequest viewBookingsRequest);

    CancelBookingResponse cancelBooking(Long id);

    LogoutGuestResponse logoutGuest(LogoutGuestRequest logoutGuestRequest);





}
