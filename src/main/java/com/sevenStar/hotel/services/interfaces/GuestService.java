package com.sevenStar.hotel.services.interfaces;

import com.sevenStar.hotel.dtos.requests.LoginGuestRequest;
import com.sevenStar.hotel.dtos.requests.RegisterGuestRequest;
import com.sevenStar.hotel.dtos.responses.LoginGuestResponse;
import com.sevenStar.hotel.dtos.responses.RegisterGuestResponse;

public interface GuestService {

    RegisterGuestResponse registerGuest(RegisterGuestRequest registerGuestRequest);

    LoginGuestResponse loginGuest(LoginGuestRequest loginGuestRequest);

}
