package com.sevenStar.hotel.web;

import com.sevenStar.hotel.dtos.requests.AddRoomRequest;
import com.sevenStar.hotel.dtos.requests.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.requests.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.response.ApiResponse;
import com.sevenStar.hotel.dtos.response.DeleteGuestResponse;
import com.sevenStar.hotel.dtos.response.LoginGuestResponse;
import com.sevenStar.hotel.dtos.response.LogoutGuestResponse;
import com.sevenStar.hotel.dtos.response.RegisterGuestResponse;
import com.sevenStar.hotel.enums.UserRoles;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.entities.Room;
import com.sevenStar.hotel.services.implementation.BookingServiceImpl;
import com.sevenStar.hotel.services.interfaces.RoomService;
import com.sevenStar.hotel.services.interfaces.UserService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@RolesAllowed(UserRoles.Fields.ADMIN)
public class AdminController {

    @Autowired
    private RoomService roomService;

    @Autowired
    private BookingServiceImpl bookingService;
    @Autowired
    private UserService guestServiceImpl;


    @PostMapping("/registerAdmin")
    public ResponseEntity<?> registerAdmin(@RequestBody RegisterGuestRequest registerGuestRequest){
        try{
            RegisterGuestResponse registerGuestResponse = guestServiceImpl.registerGuest(registerGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, registerGuestResponse.getMessage()), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/loginAdmin")
    public ResponseEntity<?> loginAdmin(@RequestBody LoginGuestRequest loginGuestRequest){
        try{
            LoginGuestResponse loginGuestResponse = guestServiceImpl.loginGuest(loginGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, loginGuestResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/add-room")
    public ResponseEntity<String> addRoom(@RequestBody AddRoomRequest room) {
        roomService.addRoom(room);
        return ResponseEntity.ok("Room added successfully!");
    }
    @PutMapping("/update-room")
    public ResponseEntity<String> updateRoom(@RequestBody UpdateRoomRequest room) {
        roomService.updateRoom(room);
        return ResponseEntity.ok("Room updated successfully!");
    }

    @DeleteMapping("/delete-room")
    public ResponseEntity<String> deleteRoom(@RequestBody DeleteRoomRequest room) {
        roomService.deleteRoom(room);
        return ResponseEntity.ok("Room deleted successfully!");
    }

    @GetMapping("/allRooms")
    public List<Room> viewAllRooms() {
        return roomService.reviewRooms().getRooms();
    }



    @GetMapping("/bookings")
    public List<Booking> viewAllBookings() {
        return bookingService.getAllBookings();
    }

    @DeleteMapping("/cancel-booking")
    public ResponseEntity<String> deleteBooking(@RequestBody CancelBookingRequest booking) {
        bookingService.deleteBooking(booking);
        return ResponseEntity.ok("Booking canceled successfully!");
    }

//    @GetMapping("/guests")
//    public List<GuestUser> viewAllGuests() {
//        return guestServiceImpl.g
//    }
    @PostMapping("/logoutGuest")
    public ResponseEntity<?> logoutGuest(@RequestBody LogoutGuestRequest logoutGuestRequest) {
        try {
            LogoutGuestResponse logoutGuestResponse = guestServiceImpl.logoutGuest(logoutGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, logoutGuestResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteGuest")
    public ResponseEntity<?> deleteGuest(@RequestBody DeleteGuestRequest deleteGuestRequest){
        try{
            DeleteGuestResponse deleteGuestResponse = guestServiceImpl.deleteGuest(deleteGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, deleteGuestResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }
}
