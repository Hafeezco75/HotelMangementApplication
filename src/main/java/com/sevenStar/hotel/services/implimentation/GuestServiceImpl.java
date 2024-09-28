package com.sevenStar.hotel.services.implimentation;

import com.sevenStar.hotel.dtos.requests.LoginGuestRequest;
import com.sevenStar.hotel.dtos.requests.RegisterGuestRequest;
import com.sevenStar.hotel.dtos.responses.LoginGuestResponse;
import com.sevenStar.hotel.dtos.responses.RegisterGuestResponse;
import com.sevenStar.hotel.exceptions.*;
import com.sevenStar.hotel.models.entities.GuestUser;
import com.sevenStar.hotel.models.repositories.GuestRepository;
import com.sevenStar.hotel.services.interfaces.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public RegisterGuestResponse registerGuest(RegisterGuestRequest registerGuestRequest) {
        validateRegisterGuestRequest(registerGuestRequest);
        validateEmail(registerGuestRequest.getEmail());

        GuestUser guestUser = new GuestUser();
        guestUser.setFirstName(registerGuestRequest.getFirstName());
        guestUser.setLastName(registerGuestRequest.getLastName());
        guestUser.setEmail(registerGuestRequest.getEmail());
        guestUser.setPhoneNumber(registerGuestRequest.getPhoneNumber());
        guestUser.setPassword(registerGuestRequest.getPassword());
        guestRepository.save(guestUser);
        RegisterGuestResponse registerGuestResponse = new RegisterGuestResponse();
        registerGuestResponse.setMessage("Guest Successfully registered!");
        return registerGuestResponse;


    }

    @Override
    public LoginGuestResponse loginGuest(LoginGuestRequest loginGuestRequest) {

        GuestUser guestUser = guestRepository.findByEmail(loginGuestRequest.getEmail().toLowerCase());
        if (guestUser == null) {
            throw new GuestNotFoundException("Guest Not Found");
        }
        if (!guestUser.getPassword().equals(loginGuestRequest.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
        LoginGuestResponse loginGuestResponse = new LoginGuestResponse();
        loginGuestResponse.setMessage("Guest Successfully logged in");
        return loginGuestResponse;
    }

    private void validateEmail(String email) {
        GuestUser existingGuest = guestRepository.findByEmail(email);
        if (existingGuest != null && existingGuest.getEmail().equalsIgnoreCase(email)) {
            throw new GuestAlreadyExistException("Guest with same email already exist");
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
}
