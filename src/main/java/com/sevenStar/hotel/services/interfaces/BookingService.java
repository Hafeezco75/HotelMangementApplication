package com.sevenStar.hotel.services.interfaces;

import com.sevenStar.hotel.dtos.requests.CancelBookingRequest;
import com.sevenStar.hotel.dtos.requests.CreateBookingRequest;
import com.sevenStar.hotel.dtos.requests.UpdateBookingRequest;
import com.sevenStar.hotel.dtos.requests.ViewBookingsRequest;
import com.sevenStar.hotel.dtos.response.CreateBookingResponse;
import com.sevenStar.hotel.dtos.response.DeleteRoomResponse;
import com.sevenStar.hotel.dtos.response.UpdateBookingResponse;
import com.sevenStar.hotel.dtos.response.CancelBookingResponse;
import com.sevenStar.hotel.dtos.response.ViewBookingsResponse;
import com.sevenStar.hotel.models.entities.Booking;

import java.util.List;

public interface BookingService {
    CreateBookingResponse createBooking(CreateBookingRequest createRequest);

    CancelBookingResponse deleteBooking(CancelBookingRequest deleteRequest);

    List<Booking> getAllBookings();

    UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest);

    ViewBookingsResponse getBooking(ViewBookingsRequest viewBookingsRequest);

    DeleteRoomResponse deleteAll();
}
