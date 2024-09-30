package com.sevenStar.hotel.web;

import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.response.AddRoomResponse;
import com.sevenStar.hotel.dtos.response.DeleteRoomResponse;
import com.sevenStar.hotel.dtos.response.ReviewAllResponse;
import com.sevenStar.hotel.dtos.response.UpdateRoomResponse;
import com.sevenStar.hotel.enums.UserRoles;
import com.sevenStar.hotel.exceptions.RoomNotFoundException;
import com.sevenStar.hotel.services.interfaces.RoomService;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
@RolesAllowed(UserRoles.Fields.ADMIN)
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping("/addRoom")
    public ResponseEntity<?> addRoom(@RequestBody AddRoomRequest room) {
        try{
            AddRoomResponse response = roomService.addRoom(room);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/getRoom/{roomNumber}")
    public ResponseEntity<?> getRoom(@PathVariable("roomNumber") int roomNumber) {
        try{
            AddRoomResponse response = roomService.searchByRoomNumber(roomNumber);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(RoomNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAllRooms() {
        try{
            ReviewAllResponse response = roomService.reviewRooms();
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(RoomNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/update")
    public ResponseEntity<?> updateRoom(@RequestBody UpdateRoomRequest room) {

        try{
            UpdateRoomResponse response = roomService.updateRoom(room);
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch(RoomNotFoundException exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteRoom(@RequestBody DeleteRoomRequest room) {
         try{
            DeleteRoomResponse response = roomService.deleteRoom(room);
            return new ResponseEntity<>(response, HttpStatus.OK);
         }
         catch(RoomNotFoundException exception){
             return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
         }
    }
}

