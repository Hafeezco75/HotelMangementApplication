package com.sevenStar.hotel.services.interfaces;

import com.sevenStar.hotel.dtos.requests.AddRoomRequest;
import com.sevenStar.hotel.dtos.requests.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.requests.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.response.*;
import com.sevenStar.hotel.models.entities.Booking;
import java.util.List;

public interface UserService {

    RegisterGuestResponse registerGuest(RegisterGuestRequest registerGuestRequest);

    LoginGuestResponse loginGuest(LoginGuestRequest loginGuestRequest);

    UpdateGuestResponse updateGuest(UpdateGuestRequest updateGuestRequest);

    DeleteGuestResponse deleteAllGuest();

    DeleteGuestResponse deleteGuest(DeleteGuestRequest deleteGuestRequest);

    LogoutGuestResponse logoutGuest(LogoutGuestRequest logoutGuestRequest);

    CreateBookingResponse makeBooking(CreateBookingRequest makeBookingRequest);

    CancelBookingResponse cancelBooking(CancelBookingRequest deleteRequest);


    List<Booking> getAllBookings();

    UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest);

    ViewBookingsResponse viewBookings(ViewBookingsRequest viewBookingsRequest);

    DeleteRoomResponse deleteAll();

    AddRoomResponse addRoom(AddRoomRequest request);

    UpdateRoomResponse updateRoom(UpdateRoomRequest room);

    DeleteRoomResponse deleteRoom(DeleteRoomRequest room);

    ReviewAllResponse reviewRooms();

    AddRoomResponse searchByRoomNumber(int roomNumber);

    AddRoomResponse deleteAllRooms();


}
