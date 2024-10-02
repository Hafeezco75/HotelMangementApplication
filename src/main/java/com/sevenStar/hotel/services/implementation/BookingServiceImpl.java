package com.sevenStar.hotel.services.implementation;

import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.response.CreateBookingResponse;
import com.sevenStar.hotel.dtos.response.DeleteRoomResponse;
import com.sevenStar.hotel.dtos.response.UpdateBookingResponse;
import com.sevenStar.hotel.dtos.response.CancelBookingResponse;
import com.sevenStar.hotel.dtos.response.ViewBookingsResponse;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.repositories.BookingRepository;
import com.sevenStar.hotel.services.interfaces.BookingService;
import com.sevenStar.hotel.exceptions.BookingInformationExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public CreateBookingResponse createBooking(CreateBookingRequest createRequest) {
        validateBookingRoom(createRequest);
        Booking booking = new Booking();
        booking.setCheckIn(createRequest.getCheckIn());
        booking.setCheckOut(createRequest.getCheckOut());
        booking.setRoom(createRequest.getRoom());
        booking.setPaymentMethod(createRequest.getPaymentMethod());
        Booking savedBooking = bookingRepository.save(booking);
        CreateBookingResponse createResponse = new CreateBookingResponse();
        createResponse.setBookingID(savedBooking.getBookingID());
        createResponse.setMessage("Booking Successfully Created");
        return createResponse;
    }

    @Override
    public CancelBookingResponse deleteBooking(CancelBookingRequest deleteRequest) {
        Long bookingID = deleteRequest.getBookingID();
        Booking bookings = bookingRepository.findById(bookingID).orElse(null);

        if (bookings == null) {
            throw new BookingInformationExistException("Booking ID does not exist");
        }
        bookingRepository.deleteById(bookingID);

        CancelBookingResponse deleteResponse = new CancelBookingResponse();
        deleteResponse.setMessage("Booking Information has been successfully deleted");
        return deleteResponse;
    }


    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();

    }

    @Override
    public UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest){
        Booking bookings = findById(updateRequest.getBookingID());
        if (bookings == null) {
            throw new RuntimeException("Booking ID does not exist");
        }

        bookings.setCheckIn(updateRequest.getCheckIn());
        bookings.setCheckOut(updateRequest.getCheckOut());
        bookings.setRoom(updateRequest.getRoom());
        bookingRepository.save(bookings);

        UpdateBookingResponse updateResponse = new UpdateBookingResponse();
        updateResponse.setMessage("Booking details updated successfully");
        return updateResponse;
    }

    @Override
    public ViewBookingsResponse getBooking(ViewBookingsRequest viewBookingsRequest) {
        Booking foundBooking = findById(viewBookingsRequest.getBookingId());
        ViewBookingsResponse viewBookingsResponse = new ViewBookingsResponse();
        viewBookingsResponse.setBooking(foundBooking);
        viewBookingsResponse.setMessage("Booking details retrieved successfully");
        return viewBookingsResponse;
    }

    @Override
    public DeleteRoomResponse deleteAll() {
        bookingRepository.deleteAll();
        DeleteRoomResponse deleteRoomResponse = new DeleteRoomResponse();
        deleteRoomResponse.setMessage("All bookings deleted successfully");
        return deleteRoomResponse;
    }

    private void validateBookingRoom(CreateBookingRequest createRequest) {
        if (!createRequest.getRoom().isRoomAvailable()) {
            throw new BookingInformationExistException("Room selected Has Been booked Already !!!");
        }
    }

    private Booking findById(Long id){
        return bookingRepository.findById(id).orElseThrow(() -> new BookingInformationExistException("Booking does not exist"));
    }
}