package com.sevenStar.hotel.web;

import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.requests.DeleteBookingRequest;
import com.sevenStar.hotel.dtos.requests.DeleteGuestRequest;
import com.sevenStar.hotel.dtos.requests.GetBookingRequest;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.entities.GuestUser;
import com.sevenStar.hotel.models.entities.Room;
import com.sevenStar.hotel.services.implementation.BookingServiceImpl;
import com.sevenStar.hotel.services.implementation.GuestServiceImpl;
import com.sevenStar.hotel.services.interfaces.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private RoomService roomService; // Service to manage rooms

    @Autowired
    private BookingServiceImpl bookingService; // Service to manage bookings
    @Autowired
    private GuestServiceImpl guestServiceImpl;


    // Room Management services for admin

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

    @GetMapping("/rooms")
    public List<Room> viewAllRooms() {
        return roomService.reviewRooms().getRooms();
    }

    // Booking Management

    @GetMapping("/bookings")
    public List<Booking> viewAllBookings() {
        return bookingService.getAllBookings();
    }

//    @GetMapping("/booking")
//    public ResponseEntity<Booking> getBookingDetails(@RequestBody ) {
//        Booking booking = bookingService.getAllBookings(bookingId);
//        return ResponseEntity.ok(booking);
//    }

    @DeleteMapping("/cancel-booking/{bookingId}")
    public ResponseEntity<String> deleteBooking(@RequestBody DeleteBookingRequest booking) {
        bookingService.deleteBooking(booking);
        return ResponseEntity.ok("Booking canceled successfully!");
    }

    // Guest Management
//    @GetMapping("/guests")
//    public List<GuestUser> viewAllGuests() {
//        return guestServiceImpl.g
//    }

//    @GetMapping("/guest/{guestId}")
//    public ResponseEntity<User> getGuestDetails(@PathVariable Long guestId) {
//        User guest = userService.getGuestById(guestId);
//        return ResponseEntity.ok(guest);
//    }

    @DeleteMapping("/delete-guest")
    public ResponseEntity<?> deleteGuest(@RequestBody DeleteGuestRequest guest) {
        guestServiceImpl.deleteGuest(guest);
        return ResponseEntity.ok("Guest deleted successfully!");
    }

}
