package com.sevenStar.hotel.services.implementation;

import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.response.*;
import com.sevenStar.hotel.models.entities.Room;
import com.sevenStar.hotel.models.repositories.RoomRepository;
import com.sevenStar.hotel.services.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest

public class UserServiceTest {
    @Autowired
    private UserService guestUser;

    @Autowired
    private RoomRepository roomRepo;


   @BeforeEach
   void setUp() {
       guestUser.deleteAllGuest();
       RegisterGuestRequest registerGuestRequest = new RegisterGuestRequest();
       registerGuestRequest.setFirstName("sekinat");
       registerGuestRequest.setLastName("Loco");
       registerGuestRequest.setEmail("sekinat@gmail.com");
       registerGuestRequest.setPhoneNumber("08051156815");
       registerGuestRequest.setPassword("password");
       guestUser.registerGuest(registerGuestRequest);
   }


    @Test
    public void testToRegisterGuest() {
        RegisterGuestRequest registerGuestRequest = new RegisterGuestRequest();
        registerGuestRequest.setFirstName("seriki");
        registerGuestRequest.setLastName("goat");
        registerGuestRequest.setEmail("goat@gmail.com");
        registerGuestRequest.setPhoneNumber("08051156815");
        registerGuestRequest.setPassword("pass");
        RegisterGuestResponse response = guestUser.registerGuest(registerGuestRequest);
        assertNotNull(response);
        assertThat(response.getMessage()).isEqualTo("User Successfully registered!");
    }

    @Test
    public void testThatRegisteredGuestCanLogin(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestUser.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("User Successfully logged in");

    }

    @Test
    public void testThatRegisteredGuestCanUpdateDetails(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestUser.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("User Successfully logged in");

        UpdateGuestRequest updateGuestRequest = new UpdateGuestRequest();
        updateGuestRequest.setFirstName("sekinat");
        updateGuestRequest.setLastName("bisiriyu");
        updateGuestRequest.setEmail("sekinat@gmail.com");
        updateGuestRequest.setPhoneNumber("08051156815");
        updateGuestRequest.setPassword("password");
        UpdateGuestResponse updateGuestResponse = guestUser.updateGuest(updateGuestRequest);
        assertNotNull(updateGuestResponse);
        assertThat(updateGuestResponse.getMessage()).isEqualTo("User Successfully updated");
    }

    @Test
    public void testThatRegisteredGuestCanDeleteTheirProfile(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestUser.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("User Successfully logged in");

        DeleteGuestRequest deleteGuestRequest = new DeleteGuestRequest();
        deleteGuestRequest.setEmail("sekinat@gmail.com");
        DeleteGuestResponse deleteResponse = guestUser.deleteGuest(deleteGuestRequest);
        assertNotNull(deleteResponse);
        assertThat(deleteResponse.getMessage()).isEqualTo("User Successfully deleted");
    }

    @Test
    public void testThatGuestCanMakeBooking(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestUser.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("User Successfully logged in");

        CreateBookingRequest makeBookingRequest = new CreateBookingRequest();
        makeBookingRequest.setRoom(createRoom());
        makeBookingRequest.setCheckIn(LocalDate.of(2021,8,21));
        makeBookingRequest.setCheckOut(LocalDate.now());
        makeBookingRequest.setPaymentMethod("Credit Card");
        makeBookingRequest.setUserId(createUser().getUserId());
        CreateBookingResponse response = guestUser.makeBooking(makeBookingRequest);
        assertNotNull(response);
        assertThat(response.getMessage()).isEqualTo("Booking Successfully Created");
    }

    @Test
    public void testThatGuestCanViewTheirBookings(){

        Long userId =createUser().getUserId();
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestUser.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("User Successfully logged in");

        CreateBookingRequest makeBookingRequest = new CreateBookingRequest();
        makeBookingRequest.setRoom(createRoom());
        makeBookingRequest.setCheckIn(LocalDate.of(2021,8,21));
        makeBookingRequest.setCheckOut(LocalDate.now());
        makeBookingRequest.setPaymentMethod("Credit Card");
        makeBookingRequest.setUserId(userId);
        CreateBookingResponse response = guestUser.makeBooking(makeBookingRequest);

        ViewBookingsRequest viewBookingsRequest = new ViewBookingsRequest();
        viewBookingsRequest.setUserId(userId);
        viewBookingsRequest.setBookingId(response.getBookingID());
        ViewBookingsResponse viewBookings = guestUser.viewBookings(viewBookingsRequest);
        assertNotNull(viewBookings);
        assertThat(viewBookings.getBooking().getBookingID()).isEqualTo(response.getBookingID());
        assertThat(viewBookings.getMessage()).isEqualTo("Booking details retrieved successfully");
    }

    @Test
    public void testThatGuestCanCancelBooking(){

        Long userId = createUser().getUserId();
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("janet@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestUser.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("User Successfully logged in");

        CreateBookingRequest request = new CreateBookingRequest();
        request.setCheckIn(LocalDate.of(2023,3,17));
        request.setCheckOut(LocalDate.now());
        request.setRoom(createRoom());
        request.setPaymentMethod("Credit Card");
        request.setUserId(userId);

        CreateBookingResponse response = guestUser.makeBooking(request);
        CancelBookingRequest cancelBookingRequest = new CancelBookingRequest();
        cancelBookingRequest.setBookingID(response.getBookingID());
        CancelBookingResponse cancelled = guestUser.cancelBooking(cancelBookingRequest);
        assertThat(cancelled.getMessage()).isEqualTo("Booking Information has been successfully deleted");
        
    }

    @Test
    public void testThatLoggedInGuestCanLogout(){
        LoginGuestRequest loginGuestRequest = new LoginGuestRequest();
        loginGuestRequest.setEmail("sekinat@gmail.com");
        loginGuestRequest.setPassword("password");
        LoginGuestResponse loginGuestResponse = guestUser.loginGuest(loginGuestRequest);
        assertNotNull(loginGuestResponse);
        assertThat(loginGuestResponse.getMessage()).isEqualTo("User Successfully logged in");

        LogoutGuestRequest logoutGuestRequest = new LogoutGuestRequest();
        logoutGuestRequest.setEmail("sekinat@gmail.com");
        LogoutGuestResponse logoutGuestResponse = guestUser.logoutGuest(logoutGuestRequest);
        assertNotNull(logoutGuestResponse);
        assertThat(logoutGuestResponse.getMessage()).isEqualTo("User Successfully logged out");
    }

    private Room createRoom() {
        Room request = new Room();
        request.setRoomType("STANDARD");
        request.setDescription("The Room is a standard and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(65000));
        request.setRoomImage("imagesURL");
        request.setRoomNumber(5990);
        request.setRoomAvailable(true);
        return roomRepo.save(request);

    }
    private RegisterGuestResponse createUser(){
        RegisterGuestRequest registerGuestRequest = new RegisterGuestRequest();
        registerGuestRequest.setFirstName("janet");
        registerGuestRequest.setLastName("trouble");
        registerGuestRequest.setEmail("janet@gmail.com");
        registerGuestRequest.setPhoneNumber("08051156815");
        registerGuestRequest.setPassword("password");
        return guestUser.registerGuest(registerGuestRequest);
    }

}