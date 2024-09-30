package com.sevenStar.hotel.services;

import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.responses.*;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.repositories.GuestUserRepository;
import com.sevenStar.hotel.services.interfaces.GuestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class GuestServiceTest {
    @Autowired
    private GuestService guestService;

    @Autowired
    private GuestUserRepository guestRepository;


    @Test
    public void testToRegisterGuest() {
        RegisterGuestRequest registerGuestRequest = new RegisterGuestRequest();
        registerGuestRequest.setFirstName("sekinat");
        registerGuestRequest.setLastName("Loco");
        registerGuestRequest.setEmail("sekinat@gmail.com");
        registerGuestRequest.setPhoneNumber("08051156815");
        registerGuestRequest.setPassword("password");
        RegisterGuestResponse response = guestService.registerGuest(registerGuestRequest);
        assertNotNull(response);
        assertThat(response.getMessage()).isEqualTo("Guest Successfully registered!");



    }

    @Test
    public void testThatRegisteredGuestCanLogin(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestService.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("Guest Successfully logged in");

    }

    @Test
    public void testThatRegisteredGuestCanUpdateDetails(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestService.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("Guest Successfully logged in");

        UpdateGuestRequest updateGuestRequest = new UpdateGuestRequest();
        updateGuestRequest.setFirstName("sekinat");
        updateGuestRequest.setLastName("bisiriyu");
        updateGuestRequest.setEmail("sekinat@gmail.com");
        updateGuestRequest.setPhoneNumber("08051156815");
        updateGuestRequest.setPassword("password");
        UpdateGuestResponse updateGuestResponse = guestService.updateGuest(updateGuestRequest);
        assertNotNull(updateGuestResponse);
        assertThat(updateGuestResponse.getMessage()).isEqualTo("Guest Successfully updated");


    }

    @Test
    public void testThatRegisteredGuestCanDeleteTheirProfile(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestService.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("Guest Successfully logged in");

        DeleteGuestRequest deleteGuestRequest = new DeleteGuestRequest();
        deleteGuestRequest.setEmail("sekinat@gmail.com");
        DeleteGuestResponse deleteResponse = guestService.deleteGuest(deleteGuestRequest);
        assertNotNull(deleteResponse);
        assertThat(deleteResponse.getMessage()).isEqualTo("Guest Successfully deleted");
    }

    @Test
    public void testThatGuestCanMakeBooking(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestService.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("Guest Successfully logged in");

        MakeBookingRequest makeBookingRequest = new MakeBookingRequest();
        makeBookingRequest.setEmail("sekinat@gmail.com");
        makeBookingRequest.setCheckInDate(LocalDate.of(2021,8,21));
        makeBookingRequest.setCheckOutDate(LocalDate.now());
        makeBookingRequest.setRoomType("Standard");
        makeBookingRequest.setPaymentMethod("Credit Card");


        MakeBookingResponse makeBookingResponse = guestService.makeBooking(makeBookingRequest);
        assertNotNull(makeBookingResponse);
        assertThat(makeBookingResponse.getMessage()).isEqualTo("Booking Successfully made");
    }

//    @Test
//    public void testThatGuestCanViewTheirBookings(){
//        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
//        loginGuestRequest.setEmail("sekinat@gmail.com");
//        loginGuestRequest.setPassword("password");
//        LoginGuestResponse loginGuestResponse = guestService.loginGuest(loginGuestRequest);
//        assertNotNull(loginGuestResponse);
//        assertThat(loginGuestResponse.getMessage()).isEqualTo("Guest Successfully logged in");
//
//        ViewBookingsRequest viewBookingsRequest = new ViewBookingsRequest();
//        viewBookingsRequest.setEmail("sekinat@gmail.com");
//        viewBookingsRequest.setId(1L);
//        Booking viewBookings = guestService.viewBookings(viewBookingsRequest);
//        assertNotNull(viewBookings);
//        assertThat(viewBookings.getBookingID()).isEqualTo(1L);
//        assertThat(viewBookings.getRoomType()).isEqualTo("Standard");
//    }

    @Test
    public void testThatGuestCanCancelBooking(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestService.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("Guest Successfully logged in");

        CancelBookingRequest cancelBookingRequest = new CancelBookingRequest();
        cancelBookingRequest.setBookingId(1L);
        assertThat(cancelBookingRequest.getBookingId()).isEqualTo(1L);
        CancelBookingResponse response = guestService.cancelBooking(cancelBookingRequest.getBookingId());
        assertThat(response.getMessage()).isEqualTo("Booking Successfully cancelled");
        
    }

    @Test
    public void testThatLoggedInGuestCanLogout(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestService.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("Guest Successfully logged in");

        LogoutGuestRequest logoutGuestRequest = new LogoutGuestRequest();
        logoutGuestRequest.setEmail("sekinat@gmail.com");
        LogoutGuestResponse logoutGuestResponse = guestService.logoutGuest(logoutGuestRequest);
        assertNotNull(logoutGuestResponse);
        assertThat(logoutGuestResponse.getMessage()).isEqualTo("Guest Successfully logged out");
    }

}