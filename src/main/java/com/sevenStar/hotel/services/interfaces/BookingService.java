package com.sevenStar.hotel.services.interfaces;

import com.sevenStar.hotel.dtos.requests.CreateBookingRequest;
import com.sevenStar.hotel.dtos.requests.DeleteBookingRequest;
import com.sevenStar.hotel.dtos.requests.GetBookingRequest;
import com.sevenStar.hotel.dtos.requests.UpdateBookingRequest;
import com.sevenStar.hotel.dtos.response.CreateBookingResponse;
import com.sevenStar.hotel.dtos.response.DeleteBookingResponse;
import com.sevenStar.hotel.dtos.response.UpdateBookingResponse;
import com.sevenStar.hotel.models.entities.Booking;

import java.util.List;

public interface BookingService {
    CreateBookingResponse createBooking(CreateBookingRequest createRequest);

    DeleteBookingResponse deleteBooking(DeleteBookingRequest deleteRequest);

    List<Booking> getAllBookings();

    UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest);

}
