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
import com.sevenStar.hotel.models.entities.Room;
import com.sevenStar.hotel.services.interfaces.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class BookingServiceImplTest {

    @Autowired
    private BookingService bookingService;

    @Test
    public void testThatBookingCanBeCreated() {
        UserRoles userRole = UserRoles.ADMIN;
        CreateBookingRequest request = new CreateBookingRequest();
        request.setCheckIn(LocalDate.of(2023,3,17));
        request.setCheckOut(LocalDate.now());
        Room room = new Room();
        room.setRoomAvailable(true);
        room.setRoomImage("Beautiful Room");
        room.setDescription("An Exquisite room and classy one");
        room.setRoomPrice(new BigDecimal("15.0"));
        room.setRoomType("Deluxe");
        request.setRoom(room);
        request.setUserRole(userRole);
        CreateBookingResponse response = bookingService.createBooking(request);
        assertThat(response.getMessage()).isEqualTo("Reservation details created successfully");
    }

    @Test
    public void testThatBookingCanBeUpdated() {
        UpdateBookingRequest request = new UpdateBookingRequest();
        request.setBookingID(2L);
        request.setCheckIn(LocalDate.of(2024,7,27));
        request.setCheckOut(LocalDate.now());
        Room room = new Room();
        room.setRoomAvailable(true);
        room.setRoomImage("Basic Room");
        room.setDescription("A Real home");
        room.setRoomPrice(new BigDecimal("98000.0"));
        room.setRoomType("Standard");
        request.setRoom(room);
        UpdateBookingResponse response = bookingService.updateBooking(request);
        assertThat(response.getMessage()).isEqualTo("Booking details updated successfully");
    }

    @Test
    public void testThatBookingInformationCanBeDeleted() {
        DeleteBookingRequest deleteRequest = new DeleteBookingRequest();
        deleteRequest.setBookingID(5L);
        DeleteBookingResponse response = bookingService.deleteBooking(deleteRequest);
        assertThat(response.isBookingStatus()).isEqualTo(false);
        assertThat(response.getMessage()).isEqualTo("Booking Information has been successfully deleted");
    }

    @Test
    public void testThatBookingInformationCanBeRetrieved() {
        GetBookingRequest getRequest = new GetBookingRequest();
        getRequest.setBookingID(1L);
        List<Booking> booking = bookingService.getAllBookings(getRequest);
        assertThat(booking.isEmpty()).isFalse();
        assertThat(booking.size()).isEqualTo(1);
    }

}