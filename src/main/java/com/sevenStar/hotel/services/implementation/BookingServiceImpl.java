package com.sevenStar.hotel.services.implementation;

import com.sevenStar.hotel.dtos.requests.CreateBookingRequest;
import com.sevenStar.hotel.dtos.requests.DeleteBookingRequest;
import com.sevenStar.hotel.dtos.requests.GetBookingRequest;
import com.sevenStar.hotel.dtos.requests.UpdateBookingRequest;
import com.sevenStar.hotel.dtos.response.CreateBookingResponse;
import com.sevenStar.hotel.dtos.response.DeleteBookingResponse;
import com.sevenStar.hotel.dtos.response.UpdateBookingResponse;
import com.sevenStar.hotel.enums.UserRoles;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.repositories.BookingRepository;
import com.sevenStar.hotel.services.interfaces.BookingService;
import com.sevenStar.hotel.exceptions.BookingIDAlreadyExistException;
import com.sevenStar.hotel.exceptions.BookingInformationExistException;
import com.sevenStar.hotel.exceptions.InvalidBookingRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Override
    public CreateBookingResponse createBooking(CreateBookingRequest createRequest) {
        validateUserRoles();
        validateBookings(createRequest);
        validateBookingInformation(createRequest);
        validateBookingRoomIsNotNull();
        Booking booking = new Booking();
        booking.setBookingID(createRequest.getBookingID());
        booking.setCheckIn(createRequest.getCheckIn());
        booking.setCheckOut(createRequest.getCheckOut());
        booking.setRoom(createRequest.getRoom());
        booking.setRoomType(createRequest.getRoomType());
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
                throw new BookingIDAlreadyExistException("Booking ID already exists");
            }else {
                booking.setBookingID(bookingID);
            }
        }
    }

    @Override
    public DeleteBookingResponse deleteBooking(DeleteBookingRequest deleteRequest) {
        Long bookingID = deleteRequest.getBookingID();
        Booking bookings = bookingRepository.findById(bookingID).orElse(null);

        if (bookings == null) {
            throw new BookingInformationExistException("Booking ID does not exist");
        }
        deleteRequest.setBookingStatus(false);
        bookingRepository.deleteById(bookingID);

        DeleteBookingResponse deleteResponse = new DeleteBookingResponse();
        deleteResponse.setBookingStatus(deleteRequest.isBookingStatus());
        deleteResponse.setMessage("Booking Information has been successfully deleted");
        return deleteResponse;
    }


    @Override
    public List<Booking> getAllBookings(GetBookingRequest getRequest) {
        List<Booking> bookings = bookingRepository.findAll();
        return bookings;
    }

    @Override
    public UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest){
        Booking bookings = bookingRepository.findByRoomTypeAndBookingID(updateRequest.getRoomType(), updateRequest.getBookingID());
        if (bookings == null) {
            throw new RuntimeException("Booking ID does not exist");
        }
        validateUserRoles();
        bookings.setCheckIn(updateRequest.getCheckIn());
        bookings.setCheckOut(updateRequest.getCheckOut());
        bookings.setRoomType(updateRequest.getRoomType());
        bookings.setRoom(updateRequest.getRoom());
        bookingRepository.save(bookings);

        UpdateBookingResponse updateResponse = new UpdateBookingResponse();
        updateResponse.setMessage("Booking details updated successfully");
        return updateResponse;
    }


    private void validateBookingRoomIsNotNull(){
       for (Booking booking : bookingRepository.findAll()) {
           if (booking.getRoom() == null) {
               throw new InvalidBookingRequestException("Booking Room Not Found,Input Valid Booking Details");
           }else {
               booking.setRoom(booking.getRoom());
           }
       }
    }

    private void validateUserRoles(){
        Optional<UserRoles> user = Optional.of(UserRoles.ADMIN);
        for (Booking booking : bookingRepository.findAll()) {
            if (user.isPresent()){
                booking.setCheckIn(booking.getCheckIn());
                booking.setCheckOut(booking.getCheckOut());
                booking.setRoom(booking.getRoom());
                booking.setRoomType(booking.getRoomType());
            }else{
                throw new RuntimeException("User Does Not Exist");
            }
        }
    }

    private void validateBookingInformation(CreateBookingRequest createRequest){
        for (Booking booking : bookingRepository.findAll()) {
            if (booking.getRoom().equals(createRequest.getRoom())) {
                if (booking.getUserRole().equals(UserRoles.ADMIN)) {
                    if (booking.getRoomType().equals(createRequest.getRoomType())) {
                        throw new BookingInformationExistException("Booking Information Already Exists, Input a new Booking Information");
                    }
                }
            }else {
                booking.setCheckIn(booking.getCheckIn());
                booking.setCheckOut(booking.getCheckOut());
            }
        }
    }

}
