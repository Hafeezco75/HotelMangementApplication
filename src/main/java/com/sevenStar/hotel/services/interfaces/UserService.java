package com.sevenStar.hotel.services.interfaces;

import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.response.*;
import com.sevenStar.hotel.dtos.responses.*;
import com.sevenStar.hotel.models.entities.Booking;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    RegisterGuestResponse registerGuest(RegisterGuestRequest registerGuestRequest);

    LoginGuestResponse loginGuest(LoginGuestRequest loginGuestRequest);

    UpdateGuestResponse updateGuest(UpdateGuestRequest updateGuestRequest);

    DeleteGuestResponse deleteGuest(DeleteGuestRequest deleteGuestRequest);

    MakeBookingResponse makeBooking(MakeBookingRequest makeBookingRequest);

    DeleteBookingResponse deleteBooking(DeleteBookingRequest deleteRequest);

    LogoutGuestResponse logoutGuest(LogoutGuestRequest logoutGuestRequest);

    AddRoomResponse addRoom(AddRoomRequest request);

    UpdateRoomResponse updateRoom(UpdateRoomRequest room);

    DeleteRoomResponse deleteRoom(DeleteRoomRequest room);

    ReviewAllResponse reviewRooms();

    AddRoomResponse searchByRoomNumber(int roomNumber);

    AddRoomResponse deleteAllRooms();

    List<Booking> viewAllBookings();

    UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest);

    CreateBookingResponse createBooking(CreateBookingRequest createRequest);


}
