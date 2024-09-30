package com.sevenStar.hotel.web;

import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.response.ApiResponse;
import com.sevenStar.hotel.dtos.responses.*;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.services.interfaces.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("api/guest")
public class GuestController {
    @Autowired
    private GuestService guestService;




    @PostMapping("/registerGuest")
    public ResponseEntity<?> registerGuest(@RequestBody RegisterGuestRequest registerGuestRequest){
        try{
            RegisterGuestResponse registerGuestResponse = guestService.registerGuest(registerGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, registerGuestResponse.getMessage()), HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/loginGuest")
    public ResponseEntity<?> loginGuest(@RequestBody LoginGuestRequest loginGuestRequest){
        try{
            LoginGuestResponse loginGuestResponse = guestService.loginGuest(loginGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, loginGuestResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/updateGuest")
    public ResponseEntity<?> updateGuest(@RequestBody UpdateGuestRequest updateGuestRequest){
        try{
            UpdateGuestResponse updateGuestResponse = guestService.updateGuest(updateGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, updateGuestResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteGuest")
    public ResponseEntity<?> deleteGuest(@RequestBody DeleteGuestRequest deleteGuestRequest){
        try{
            DeleteGuestResponse deleteGuestResponse = guestService.deleteGuest(deleteGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true, deleteGuestResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/makeBooking")
    public ResponseEntity<?> makeBooking(@RequestBody MakeBookingRequest makeBookingRequest){
        try{
            MakeBookingResponse makeBookingResponse = guestService.makeBooking(makeBookingRequest);
            return new ResponseEntity<>(new ApiResponse(true, makeBookingResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/cancelBooking")
    public ResponseEntity<?> cancelBooking(@RequestBody CancelBookingRequest cancelBookingRequest){
        try{
            CancelBookingResponse cancelBookingResponse = guestService.cancelBooking(cancelBookingRequest.getBookingId());
            return new ResponseEntity<>(new ApiResponse(true,cancelBookingResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logoutGuest")
    public ResponseEntity<?> logoutGuest(@RequestBody LogoutGuestRequest logoutGuestRequest){
        try{
            LogoutGuestResponse logoutGuestResponse = guestService.logoutGuest(logoutGuestRequest);
            return new ResponseEntity<>(new ApiResponse(true,logoutGuestResponse.getMessage()), HttpStatus.CREATED);
        } catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }



}

