package com.sevenStar.hotel.services.implementation;

import com.sevenStar.hotel.dtos.requests.AddRoomRequest;
import com.sevenStar.hotel.dtos.requests.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.requests.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.requests.*;
import com.sevenStar.hotel.dtos.response.*;
import com.sevenStar.hotel.exceptions.*;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.entities.User;
import com.sevenStar.hotel.models.repositories.UserRepository;
import com.sevenStar.hotel.services.interfaces.BookingService;
import com.sevenStar.hotel.services.interfaces.RoomService;
import com.sevenStar.hotel.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private RoomService roomService;

    @Override
    public RegisterGuestResponse registerGuest(RegisterGuestRequest registerGuestRequest) {
        validateRegisterGuestRequest(registerGuestRequest);
        validateEmail(registerGuestRequest.getEmail());

        User guestUser = new User();
        guestUser.setFirstName(registerGuestRequest.getFirstName());
        guestUser.setLastName(registerGuestRequest.getLastName());
        guestUser.setEmail(registerGuestRequest.getEmail());
        guestUser.setPhoneNumber(registerGuestRequest.getPhoneNumber());
        guestUser.setPassword(registerGuestRequest.getPassword());
        guestUser.setRole(registerGuestRequest.getRole());
        User savedUser = userRepository.save(guestUser);
        RegisterGuestResponse registerGuestResponse = new RegisterGuestResponse();
        registerGuestResponse.setUserId(savedUser.getUserId());
        registerGuestResponse.setMessage("User Successfully registered!");
        return registerGuestResponse;

    }

    @Override
    public LoginGuestResponse loginGuest(LoginGuestRequest loginGuestRequest) {
        User guestUser = findUserByEmail(loginGuestRequest.getEmail());
        if (!guestUser.getPassword().equals(loginGuestRequest.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        guestUser.setLogin(true);
        userRepository.save(guestUser);
        LoginGuestResponse loginGuestResponse = new LoginGuestResponse();
        loginGuestResponse.setMessage("User Successfully logged in");
        return loginGuestResponse;
    }

    @Override
    public UpdateGuestResponse updateGuest(UpdateGuestRequest updateGuestRequest) {
        User guestUser = findUserByEmail(updateGuestRequest.getEmail());

        guestUser.setFirstName(updateGuestRequest.getFirstName());
        guestUser.setLastName(updateGuestRequest.getLastName());
        guestUser.setEmail(updateGuestRequest.getEmail());
        guestUser.setPhoneNumber(updateGuestRequest.getPhoneNumber());
        guestUser.setPassword(updateGuestRequest.getPassword());
        userRepository.save(guestUser);

        UpdateGuestResponse updateGuestResponse = new UpdateGuestResponse();
        updateGuestResponse.setMessage("User Successfully updated");
        return updateGuestResponse;
    }

    @Override
    public DeleteGuestResponse deleteAllGuest() {

        DeleteGuestResponse response = new DeleteGuestResponse();
        userRepository.deleteAll();
        response.setMessage("User Successfully deleted");
        return response;
    }

    @Override
    public DeleteGuestResponse deleteGuest(DeleteGuestRequest deleteGuestRequest) {
        User guestUser = findUserByEmail(deleteGuestRequest.getEmail());

        userRepository.delete(guestUser);
        DeleteGuestResponse deleteGuestResponse = new DeleteGuestResponse();
        deleteGuestResponse.setMessage("User Successfully deleted");
        return deleteGuestResponse;
    }

    @Override
    public LogoutGuestResponse logoutGuest(LogoutGuestRequest logoutGuestRequest) {
        User guestUser = findUserByEmail(logoutGuestRequest.getEmail());
        guestUser.setLogin(false);
        userRepository.save(guestUser);
        LogoutGuestResponse loginGuestResponse = new LogoutGuestResponse();
        loginGuestResponse.setMessage("User Successfully logged out");
        return loginGuestResponse;
    }

    @Override
    public CreateBookingResponse makeBooking(CreateBookingRequest makeBookingRequest) {
        findById(makeBookingRequest.getUserId());
        return bookingService.createBooking(makeBookingRequest);
    }

    @Override
    public CancelBookingResponse cancelBooking(CancelBookingRequest deleteRequest) {
//        findById(deleteRequest.getUserID());
        return bookingService.deleteBooking(deleteRequest);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @Override
    public UpdateBookingResponse updateBooking(UpdateBookingRequest updateRequest) {
        return bookingService.updateBooking(updateRequest);
    }

    @Override
    public ViewBookingsResponse viewBookings(ViewBookingsRequest viewBookingsRequest) {
        findById(viewBookingsRequest.getUserId());
        return bookingService.getBooking(viewBookingsRequest);
    }

    @Override
    public DeleteRoomResponse deleteAll() {
        return bookingService.deleteAll();
    }

    @Override
    public AddRoomResponse addRoom(AddRoomRequest request) {
        return roomService.addRoom(request);
    }

    @Override
    public UpdateRoomResponse updateRoom(UpdateRoomRequest room) {
        return roomService.updateRoom(room);
    }

    @Override
    public DeleteRoomResponse deleteRoom(DeleteRoomRequest room) {
        return roomService.deleteRoom(room);
    }

    @Override
    public ReviewAllResponse reviewRooms() {
        return roomService.reviewRooms();
    }

    @Override
    public AddRoomResponse searchByRoomNumber(int roomNumber) {
        return roomService.searchByRoomNumber(roomNumber);
    }

    @Override
    public AddRoomResponse deleteAllRooms() {
        return roomService.deleteAllRooms();
    }

    private void validateEmail(String email) {
        User existingGuest = userRepository.findByEmail(email);
        if (existingGuest != null) {
            throw new GuestAlreadyExistException("User with same email already exist");
        }
        if (!email.contains("@") || !email.endsWith(".com")) {
                throw new InvalidEmailException("invalid email format");
        }
    }

    private void validateRegisterGuestRequest(RegisterGuestRequest registerGuestRequest) {
        if (registerGuestRequest.getFirstName().trim().isEmpty() || registerGuestRequest.getLastName().trim().isEmpty()
                || registerGuestRequest.getEmail().trim().isEmpty() || registerGuestRequest.getPassword().trim().isEmpty()){
            throw new InvalidRegisterRequestException("Field cannot be empty");
        }
    }

    private User findUserByEmail(String email) {
        User existingGuest = userRepository.findByEmail(email);
        if(existingGuest == null){
            throw new GuestNotFoundException("User not found.Wrong Email");
        }
        return existingGuest;
    }

    private void findById(Long id) {
        userRepository.findById(id).orElseThrow(() -> new GuestNotFoundException("User not found"));
    }
}
