package com.sevenStar.hotel.services.interfaces;

import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.requests.CreateBookingRequest;
import com.sevenStar.hotel.dtos.requests.DeleteBookingRequest;
import com.sevenStar.hotel.dtos.requests.UpdateBookingRequest;
import com.sevenStar.hotel.dtos.response.*;
import com.sevenStar.hotel.models.entities.Booking;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public interface AdminService {

    AddRoomResponse addRoom(AddRoomRequest request);

    UpdateRoomResponse updateRoom(UpdateRoomRequest room);

    DeleteRoomResponse deleteRoom(DeleteRoomRequest room);

    ReviewAllResponse reviewRooms();

    AddRoomResponse searchByRoomNumber(int roomNumber);

    AddRoomResponse deleteAllRooms();

    List<Booking> viewAllBookings();

    DeleteBookingResponse deleteBooking(DeleteBookingRequest deleteRequest);

    UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest);

    CreateBookingResponse createBooking(CreateBookingRequest createRequest);

}
