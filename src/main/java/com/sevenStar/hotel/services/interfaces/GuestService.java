package com.sevenStar.hotel.services.interfaces;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
=======
import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.responses.*;

>>>>>>> b144de605ce8a8e38e11ff12337c1d1a5e29a8b7
public interface GuestService {

    RegisterGuestResponse registerGuest(RegisterGuestRequest registerGuestRequest);

    LoginGuestResponse loginGuest(LoginGuestRequest loginGuestRequest);

    UpdateGuestResponse updateGuest(UpdateGuestRequest updateGuestRequest);

    DeleteGuestResponse deleteGuest(DeleteGuestRequest deleteGuestRequest);

    MakeBookingResponse makeBooking(MakeBookingRequest makeBookingRequest);

    ViewBookingsResponse viewBookings(ViewBookingsRequest viewBookingsRequest);

    CancelBookingResponse cancelBooking(long id);





}
