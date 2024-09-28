package com.sevenStar.hotel.services.implementation;

import com.sevenStar.hotel.dtos.requests.CreateBookingRequest;
import com.sevenStar.hotel.dtos.requests.DeleteBookingRequest;
import com.sevenStar.hotel.dtos.requests.GetBookingRequest;
import com.sevenStar.hotel.dtos.requests.UpdateBookingRequest;
import com.sevenStar.hotel.dtos.response.CreateBookingResponse;
import com.sevenStar.hotel.dtos.response.DeleteBookingResponse;
import com.sevenStar.hotel.dtos.response.UpdateBookingResponse;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.repositories.BookingRepository;
import com.sevenStar.hotel.services.interfaces.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public CreateBookingResponse createBooking(CreateBookingRequest createRequest) {
        validateBookings(createRequest);
        Booking booking = new Booking();
        booking.setBookingID(createRequest.getBookingID());
        booking.setCheckIn(createRequest.getCheckIn());
        booking.setCheckOut(createRequest.getCheckOut());
        bookingRepository.save(booking);

        CreateBookingResponse createResponse = new CreateBookingResponse();
        createResponse.setBookingID(createRequest.getBookingID());
        createResponse.setMessage("Reservation details created successfully");
        return createResponse;
    }


    private void validateBookings(CreateBookingRequest createRequest) {
        Long bookingID = createRequest.getBookingID();

        for (Booking booking : bookingRepository.findAll()) {
            if (booking.getBookingID().equals(bookingID)) {
                throw new RuntimeException("Reservation Number already exists");
            }else {
                booking.setBookingID(bookingID);
            }
        }
    }

    @Override
    public DeleteBookingResponse deleteBooking(DeleteBookingRequest deleteRequest) {
        DeleteBookingResponse deleteResponse = new DeleteBookingResponse();
        Long bookingID = deleteRequest.getBookingID();

        for (Booking bookings : bookingRepository.findAll()){
            if (bookings.getBookingID().equals(bookingID)) {
                bookingRepository.delete(bookings);
            } else {
                throw new RuntimeException("Reservation Number does not exist");
            }
        }

        deleteResponse.setBookingID(deleteRequest.getBookingID());
        deleteResponse.setBookingStatus(deleteResponse.isBookingStatus());
        deleteResponse.setMessage("Reservation successfully deleted");
        return deleteResponse;
    }


    @Override
    public List<Booking> getAllBookings(GetBookingRequest getRequest) {
        for (Booking booking : bookingRepository.findAll()) {
            if (booking.getBookingID().equals(getRequest.getBookingID())) {
                return bookingRepository.findAll();
            }else {
                throw new RuntimeException("Reservation Number is not valid");
            }
        }
        return null;
    }

    @Override
    public UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest){
        UpdateBookingResponse updateResponse = new UpdateBookingResponse();
        Long BookingID = updateRequest.getBookingID();

        for (Booking booking : bookingRepository.findAll()) {
            if (booking.getBookingID().equals(BookingID)) {
                booking.setBookingID(updateRequest.getBookingID());
                booking.setCheckIn(updateRequest.getCheckIn());
                booking.setCheckOut(updateRequest.getCheckOut());
                bookingRepository.save(booking);
            }else {
                throw new RuntimeException("Booking ID is not valid,kindly input correct BookingID");
            }
        }

        updateResponse.setBookingID(updateRequest.getBookingID());
        updateResponse.setCheckIn(updateRequest.getCheckIn());
        updateResponse.setCheckOut(updateRequest.getCheckOut());
        updateResponse.setMessage("Booking updated successfully");
        return updateResponse;
    }


    private void validateBookingRoomIsNotNull(){
       for (Booking booking : bookingRepository.findAll()) {
           if (booking.getRoom() == null) {
               throw new RuntimeException("Booking Room Not Found,Input Valid Booking ID");
           }else {
               booking.setRoom(booking.getRoom());
           }
       }
    }

}
