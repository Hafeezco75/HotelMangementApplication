package com.sevenStar.hotel.web;

import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.response.ApiResponse;
import com.sevenStar.hotel.dtos.responses.*;
import com.sevenStar.hotel.models.entities.Room;
import com.sevenStar.hotel.services.implementation.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;


    @PostMapping("/add-room")
    public ResponseEntity<String> addRoom(@RequestBody AddRoomRequest room) {
        userServiceImpl.addRoom(room);
        return ResponseEntity.ok("Room added successfully!");
    }

    @PutMapping("/update-room")
    public ResponseEntity<String> updateRoom(@RequestBody UpdateRoomRequest room) {
        userServiceImpl.updateRoom(room);
        return ResponseEntity.ok("Room updated successfully!");
    }

    @DeleteMapping("/delete-room")
    public ResponseEntity<String> deleteRoom(@RequestBody DeleteRoomRequest room) {
        userServiceImpl.deleteRoom(room);
        return ResponseEntity.ok("Room deleted successfully!");
    }

    @GetMapping("/rooms")
    public List<Room> viewAllRooms() {
        return userServiceImpl.reviewRooms().getRooms();
    }

    // Booking Management


    @DeleteMapping("/cancel-booking/{bookingId}")
    public ResponseEntity<String> deleteBooking(@RequestBody DeleteBookingRequest booking) {
        userServiceImpl.deleteBooking(booking);
        return ResponseEntity.ok("Booking canceled successfully!");
    }



    @DeleteMapping("/delete-guest")
    public ResponseEntity<?> deleteGuest(@RequestBody DeleteGuestRequest guest) {
        userServiceImpl.deleteGuest(guest);
        return ResponseEntity.ok("Guest deleted successfully!");
    }


    @PostMapping("/registerGuest")
    public ResponseEntity<?> registerGuest(@RequestBody RegisterGuestRequest registerGuestRequest){
        try{
            RegisterGuestResponse registerGuestResponse = userServiceImpl.registerGuest(registerGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, registerGuestResponse.getMessage()), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/loginGuest")
    public ResponseEntity<?> loginGuest(@RequestBody LoginGuestRequest loginGuestRequest){
        try{
            LoginGuestResponse loginGuestResponse = userServiceImpl.loginGuest(loginGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, loginGuestResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/updateGuest")
    public ResponseEntity<?> updateGuest(@RequestBody UpdateGuestRequest updateGuestRequest){
        try{
            UpdateGuestResponse updateGuestResponse = userServiceImpl.updateGuest(updateGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, updateGuestResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/makeBooking")
    public ResponseEntity<?> makeBooking(@RequestBody MakeBookingRequest makeBookingRequest){
        try{
            MakeBookingResponse makeBookingResponse = userServiceImpl.makeBooking(makeBookingRequest);
            return new ResponseEntity<>(new ApiResponse(true, makeBookingResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }



    @PostMapping("/logoutGuest")
    public ResponseEntity<?> logoutGuest(@RequestBody LogoutGuestRequest logoutGuestRequest){
        try{
            LogoutGuestResponse logoutGuestResponse = userServiceImpl.logoutGuest(logoutGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true,logoutGuestResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


}
