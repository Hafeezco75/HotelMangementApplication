//package com.sevenStar.hotel.web;
//
//import com.sevenStar.hotel.dtos.requests.CreateBookingRequest;
//import com.sevenStar.hotel.dtos.requests.DeleteBookingRequest;
//import com.sevenStar.hotel.dtos.requests.GetBookingRequest;
//import com.sevenStar.hotel.dtos.requests.UpdateBookingRequest;
//import com.sevenStar.hotel.dtos.response.ApiResponse;
//import com.sevenStar.hotel.dtos.response.CreateBookingResponse;
//import com.sevenStar.hotel.dtos.response.DeleteBookingResponse;
//import com.sevenStar.hotel.dtos.response.UpdateBookingResponse;
//import com.sevenStar.hotel.models.entities.Booking;
//import com.sevenStar.hotel.services.interfaces.BookingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/v1/")
//public class BookingController {
//
//    @Autowired
//    private BookingService bookingService;
//
//    @PostMapping("/create")
//    public ResponseEntity<?> createBooking(CreateBookingRequest createRequest) {
//        try {
//            CreateBookingResponse response = bookingService.createBooking(createRequest);
//            return new ResponseEntity<>(response, HttpStatus.CREATED);
//        }catch (Exception e) {
//            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
//    @DeleteMapping("/delete")
//    public ResponseEntity<?> deleteBooking(DeleteBookingRequest deleteRequest) {
//        try {
//            DeleteBookingResponse bookingResponse = bookingService.deleteBooking(deleteRequest);
//            return new ResponseEntity<>(bookingResponse, HttpStatus.CREATED);
//        }catch (Exception e) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("message", "Authentication failed");
//            map.put("status", false);
//            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
//
//        }
//    }
//
//    @PatchMapping("/")
//    public ResponseEntity<?> updateBooking(UpdateBookingRequest updateRequest) {
//        try {
//            UpdateBookingResponse updateResponse = bookingService.updateBooking(updateRequest);
//            return new ResponseEntity<>(updateResponse, HttpStatus.CREATED);
//
//        }catch (Exception e) {
//            Map<String, Object> map = new HashMap<>();
//            map.put("message", "Authentication failed");
//            map.put("status", false);
//            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/getBooking")
//    public ResponseEntity<?> getAllBookings(GetBookingRequest getRequest) {
//        try {
//            List<Booking> bookings = bookingService.getAllBookings();
//            return new ResponseEntity<>(bookings, HttpStatus.OK);
//        }catch (Exception e) {
//            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
//        }
//    }
//
//
//}
