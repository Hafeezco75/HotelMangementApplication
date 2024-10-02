package com.sevenStar.hotel.services.implementation;

import com.sevenStar.hotel.dtos.requests.CancelBookingRequest;
import com.sevenStar.hotel.dtos.requests.CreateBookingRequest;
import com.sevenStar.hotel.dtos.requests.UpdateBookingRequest;
import com.sevenStar.hotel.dtos.response.CreateBookingResponse;
import com.sevenStar.hotel.dtos.response.UpdateBookingResponse;
import com.sevenStar.hotel.dtos.response.CancelBookingResponse;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.entities.Room;
import com.sevenStar.hotel.models.repositories.RoomRepository;
import com.sevenStar.hotel.services.interfaces.BookingService;
import org.junit.jupiter.api.BeforeEach;
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

    @Autowired
    private RoomRepository roomRepo;

    @BeforeEach
    void setUp() {
        bookingService.deleteAll();
    }
    @Test
    public void testThatBookingCanBeCreated() {
        CreateBookingRequest request = new CreateBookingRequest();
        request.setCheckIn(LocalDate.of(2023, 3, 17));
        request.setCheckOut(LocalDate.now());
        Room room = new Room();
        room.setRoomAvailable(true);
        room.setRoomImage("Beautiful Room");
        room.setDescription("An Exquisite room and classy one");
        room.setRoomPrice(new BigDecimal("15.0"));
        room.setRoomType("Deluxe");
        roomRepo.save(room);
        request.setRoom(room);
        CreateBookingResponse response = bookingService.createBooking(request);
        assertThat(response.getMessage()).isEqualTo("Booking Successfully Created");
    }

    @Test
    public void testThatBookingCanBeUpdated() {
        CreateBookingResponse response = createBooking();
        UpdateBookingRequest request = new UpdateBookingRequest();
        request.setBookingID(response.getBookingID());
        request.setCheckIn(LocalDate.of(2024, 7, 27));
        request.setCheckOut(LocalDate.now());
        Room room = new Room();
        room.setRoomAvailable(true);
        room.setRoomImage("Basic Room");
        room.setDescription("A Real home");
        room.setRoomPrice(new BigDecimal("98000.0"));
        room.setRoomType("Standard");
        roomRepo.save(room);
        request.setRoom(room);
        UpdateBookingResponse update = bookingService.updateBooking(request);
        assertThat(update.getMessage()).isEqualTo("Booking details updated successfully");
    }

    @Test
    public void testThatBookingInformationCanBeDeleted() {
        CreateBookingResponse response = createBooking();
        CancelBookingRequest deleteRequest = new CancelBookingRequest();
        deleteRequest.setBookingID(response.getBookingID());
        CancelBookingResponse cancelResponse = bookingService.deleteBooking(deleteRequest);
        assertThat(cancelResponse.getMessage()).isEqualTo("Booking Information has been successfully deleted");
    }

    @Test
    public void testThatBookingInformationCanBeRetrieved() {
        createBooking();
        List<Booking> booking = bookingService.getAllBookings();
        assertThat(booking.isEmpty()).isFalse();
        assertThat(booking.size()).isEqualTo(1);
    }

    private CreateBookingResponse createBooking() {
        CreateBookingRequest request = new CreateBookingRequest();
        request.setCheckIn(LocalDate.of(2022, 7, 17));
        request.setCheckOut(LocalDate.now());
        Room room = new Room();
        room.setRoomAvailable(true);
        room.setRoomImage("Beautiful  palace Room");
        room.setDescription("An Exquisite room and classy one inevitable");
        room.setRoomPrice(new BigDecimal("150000"));
        room.setRoomType("Standard");
        roomRepo.save(room);
        request.setRoom(room);
        return  bookingService.createBooking(request);
    }

}