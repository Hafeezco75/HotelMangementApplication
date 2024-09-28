package com.sevenStar.hotel.services.implementation;

import com.sevenStar.hotel.dtos.requests.CreateBookingRequest;
import com.sevenStar.hotel.dtos.response.CreateBookingResponse;
import com.sevenStar.hotel.models.entities.Room;
import com.sevenStar.hotel.services.interfaces.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookingServiceImplTest {

    @Autowired
    private BookingService bookingService;

    @Test
    public void testThatBookingCanBeCreated() {
        CreateBookingRequest request = new CreateBookingRequest();
        request.setCheckIn(LocalDate.of(2023,3,17));
        request.setCheckOut(LocalDate.now());
        request.setRoom((List.of(new Room())));
        CreateBookingResponse response = bookingService.createBooking(request);
        assertThat(response.getMessage()).isEqualTo("Reservation details created successfully");
    }

    @Test
    public void testThatBookingCanBeUpdated() {

    }

}