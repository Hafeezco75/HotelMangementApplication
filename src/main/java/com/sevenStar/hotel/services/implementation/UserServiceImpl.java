package com.sevenStar.hotel.services.implementation;


import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.response.*;
import com.sevenStar.hotel.dtos.responses.*;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private GuestServiceImpl guestServiceImpl;

    @Autowired
    private AdminServiceImpl adminServiceImpl;



    @Override
    public RegisterGuestResponse registerGuest(RegisterGuestRequest registerGuestRequest) {
        return guestServiceImpl.registerGuest(registerGuestRequest);
    }

    @Override
    public LoginGuestResponse loginGuest(LoginGuestRequest loginGuestRequest) {
        return guestServiceImpl.loginGuest(loginGuestRequest);
    }

    @Override
    public UpdateGuestResponse updateGuest(UpdateGuestRequest updateGuestRequest) {
        return guestServiceImpl.updateGuest(updateGuestRequest);
    }

    @Override
    public DeleteGuestResponse deleteGuest(DeleteGuestRequest deleteGuestRequest) {
        return guestServiceImpl.deleteGuest(deleteGuestRequest);
    }

    @Override
    public MakeBookingResponse makeBooking(MakeBookingRequest makeBookingRequest) {
        return guestServiceImpl.makeBooking(makeBookingRequest);
    }


    @Override
    public LogoutGuestResponse logoutGuest(LogoutGuestRequest logoutGuestRequest) {
        return guestServiceImpl.logoutGuest(logoutGuestRequest);
    }

    @Override
    public AddRoomResponse addRoom(AddRoomRequest request) {
        return adminServiceImpl.addRoom(request);
    }

    @Override
    public UpdateRoomResponse updateRoom(UpdateRoomRequest room) {
        return adminServiceImpl.updateRoom(room);
    }

    @Override
    public DeleteRoomResponse deleteRoom(DeleteRoomRequest room) {
        return adminServiceImpl.deleteRoom(room);
    }

    @Override
    public ReviewAllResponse reviewRooms() {
        return adminServiceImpl.reviewRooms();
    }

    @Override
    public AddRoomResponse searchByRoomNumber(int roomNumber) {
        return adminServiceImpl.searchByRoomNumber(roomNumber);
    }

    @Override
    public AddRoomResponse deleteAllRooms() {
        return adminServiceImpl.deleteAllRooms();
    }

    @Override
    public List<Booking> viewAllBookings() {
        return adminServiceImpl.viewAllBookings();
    }

    @Override
    public DeleteBookingResponse deleteBooking(DeleteBookingRequest deleteRequest) {
        return adminServiceImpl.deleteBooking(deleteRequest);
    }

    @Override
    public UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest) {
        return adminServiceImpl.updateBooking(updateRequest);
    }

    @Override
    public CreateBookingResponse createBooking(CreateBookingRequest createRequest) {
        return adminServiceImpl.createBooking(createRequest);
    }
}
