package com.sevenStar.hotel.services.implementation;

import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.requests.CreateBookingRequest;
import com.sevenStar.hotel.dtos.requests.DeleteBookingRequest;
import com.sevenStar.hotel.dtos.requests.UpdateBookingRequest;
import com.sevenStar.hotel.dtos.response.*;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private RoomServiceImp roomServiceImp;

    @Autowired
    private BookingServiceImpl bookingServiceImpl;




    @Override
    public AddRoomResponse addRoom(AddRoomRequest request) {
        return roomServiceImp.addRoom(request);
    }

    @Override
    public UpdateRoomResponse updateRoom(UpdateRoomRequest room) {
        return roomServiceImp.updateRoom(room);
    }

    @Override
    public DeleteRoomResponse deleteRoom(DeleteRoomRequest room) {
        return roomServiceImp.deleteRoom(room);
    }

    @Override
    public ReviewAllResponse reviewRooms() {
        return roomServiceImp.reviewRooms();
    }

    @Override
    public AddRoomResponse searchByRoomNumber(int roomNumber) {
        return roomServiceImp.searchByRoomNumber(roomNumber);
    }

    @Override
    public AddRoomResponse deleteAllRooms() {
        return roomServiceImp.deleteAllRooms();
    }

    @Override
    public List<Booking> viewAllBookings() {
        return bookingServiceImpl.getAllBookings();
    }

    @Override
    public DeleteBookingResponse deleteBooking(DeleteBookingRequest deleteRequest) {
        return bookingServiceImpl.deleteBooking(deleteRequest);
    }

    @Override
    public UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest) {
        return bookingServiceImpl.updateBooking(updateRequest);
    }

    @Override
    public CreateBookingResponse createBooking(CreateBookingRequest createRequest) {
        return bookingServiceImpl.createBooking(createRequest);
    }
}
