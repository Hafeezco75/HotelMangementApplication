package com.sevenStar.hotel.services.implimentation;

import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.responses.*;
import com.sevenStar.hotel.exceptions.*;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.entities.GuestUser;
import com.sevenStar.hotel.models.repositories.BookingRepository;
import com.sevenStar.hotel.models.repositories.GuestRepository;
import com.sevenStar.hotel.services.interfaces.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public RegisterGuestResponse registerGuest(RegisterGuestRequest registerGuestRequest) {
        validateRegisterGuestRequest(registerGuestRequest);
        validateEmail(registerGuestRequest.getEmail());

        GuestUser guestUser = new GuestUser();
        guestUser.setFirstName(registerGuestRequest.getFirstName());
        guestUser.setLastName(registerGuestRequest.getLastName());
        guestUser.setEmail(registerGuestRequest.getEmail());
        guestUser.setPhoneNumber(registerGuestRequest.getPhoneNumber());
        guestUser.setPassword(registerGuestRequest.getPassword());
        guestRepository.save(guestUser);
        RegisterGuestResponse registerGuestResponse = new RegisterGuestResponse();
        registerGuestResponse.setMessage("Guest Successfully registered!");
        return registerGuestResponse;


    }

    @Override
    public LoginGuestResponse loginGuest(LoginGuestRequest loginGuestRequest) {

        GuestUser guestUser = guestRepository.findByEmail(loginGuestRequest.getEmail().toLowerCase());
        if (guestUser == null) {
            throw new GuestNotFoundException("Guest Not Found");
        }
        if (!guestUser.getPassword().equals(loginGuestRequest.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        LoginGuestResponse loginGuestResponse = new LoginGuestResponse();
        loginGuestResponse.setMessage("Guest Successfully logged in");
        return loginGuestResponse;
    }

    @Override
    public UpdateGuestResponse updateGuest(UpdateGuestRequest updateGuestRequest) {
        GuestUser guestUser = guestRepository.findByEmail(updateGuestRequest.getEmail());
        if (guestUser == null) {
            throw new GuestNotFoundException("Guest not found");
        }
        guestUser.setFirstName(updateGuestRequest.getFirstName());
        guestUser.setLastName(updateGuestRequest.getLastName());
        guestUser.setPhoneNumber(updateGuestRequest.getPhoneNumber());
        guestUser.setPassword(updateGuestRequest.getPassword());
        guestRepository.save(guestUser);
        UpdateGuestResponse updateGuestResponse = new UpdateGuestResponse();
        updateGuestResponse.setMessage("Guest Successfully updated");
        return updateGuestResponse;

    }

    @Override
    public DeleteGuestResponse deleteGuest(DeleteGuestRequest deleteGuestRequest) {
        GuestUser guestUser = guestRepository.findByEmail(deleteGuestRequest.getEmail());

        if (guestUser == null) {
            throw new GuestNotFoundException("Guest not found");
        }
        guestRepository.delete(guestUser);
        DeleteGuestResponse deleteGuestResponse = new DeleteGuestResponse();
        deleteGuestResponse.setMessage("Guest Successfully deleted");
        return deleteGuestResponse;

    }

    @Override
    public MakeBookingResponse makeBooking(MakeBookingRequest makeBookingRequest) {
        validateBookingRequest(makeBookingRequest);
        GuestUser guestUser = guestRepository.findByEmail(makeBookingRequest.getEmail());
        if (guestUser == null) {
            throw new GuestNotFoundException("Guest not found");
        }
        Booking booking = new Booking();
        booking.setCheckInDate(makeBookingRequest.getCheckInDate());
        booking.setCheckOutDate(makeBookingRequest.getCheckOutDate());
        booking.setRoomType(makeBookingRequest.getRoomType());
        booking.setPaymentMethod(makeBookingRequest.getPaymentMethod());
        bookingRepository.save(booking);
        MakeBookingResponse makeBookingResponse = new MakeBookingResponse();
        makeBookingResponse.setMessage("Booking Successfully made");
        return makeBookingResponse;



    }

    @Override
    public ViewBookingsResponse viewBookings(ViewBookingsRequest viewBookingsRequest) {
        GuestUser guestUser = guestRepository.findByEmail(viewBookingsRequest.getEmail());
        if (guestUser == null) {
            throw new GuestNotFoundException("Guest not found");
        }
        List<Booking> bookings = bookingRepository.findByEmail(guestUser);
        ViewBookingsResponse viewBookingsResponse = new ViewBookingsResponse();
        if (bookings.isEmpty()) {
            viewBookingsResponse.setMessage("No bookings found for this guest");
        }
        else {
            viewBookingsResponse.setMessage("List of bookings successfully displayed");
        }
        return viewBookingsResponse;



    }

    @Override
    public CancelBookingResponse cancelBooking(long id) {
        bookingRepository.deleteById(id);
        CancelBookingResponse cancelBookingResponse = new CancelBookingResponse();
        cancelBookingResponse.setMessage("Booking Successfully cancelled");
        return cancelBookingResponse;
    }



    private void validateBookingRequest(MakeBookingRequest makeBookingRequest) {
        if (makeBookingRequest.getEmail() == null || makeBookingRequest.getEmail().isEmpty()) {
            throw new InvalidBookingRequestException("Guest email is required");
        }
        if (makeBookingRequest.getCheckInDate() == null ) {
            throw new InvalidBookingDateRequestException("The date is required");
        }
        if (makeBookingRequest.getCheckOutDate() == null ) {
            throw new InvalidBookingDateRequestException("The date is required");
        }
        if (makeBookingRequest.getRoomType() == null || makeBookingRequest.getRoomType().isEmpty()) {
            throw new InvalidRoomTypeRequestException("Room type is required");
        }
        if (makeBookingRequest.getCheckInDate() .isAfter(makeBookingRequest.getCheckOutDate()) ) {
            throw new InvalidCheckInDateException("Start date must be before end date");
        }
    }


    private void validateEmail(String email) {
        GuestUser existingGuest = guestRepository.findByEmail(email);
        if (existingGuest != null && existingGuest.getEmail().equalsIgnoreCase(email)) {
            throw new GuestAlreadyExistException("Guest with same email already exist");
        }

        if (!email.contains("@") || !email.endsWith(".com")) {
                throw new InvalidEmailException("invalid email format");

        }


    }

    private void validateRegisterGuestRequest(RegisterGuestRequest registerGuestRequest) {
        if (registerGuestRequest.getFirstName().trim().isEmpty() || registerGuestRequest.getLastName().trim().isEmpty()
                || registerGuestRequest.getEmail().trim().isEmpty() || registerGuestRequest.getPassword().trim().isEmpty()){
            throw new InvalidRegisterRequestException("Field cannot be empty");
        }
    }
}
