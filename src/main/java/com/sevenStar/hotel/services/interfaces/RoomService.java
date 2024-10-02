package com.sevenStar.hotel.services.interfaces;

import com.sevenStar.hotel.dtos.requests.AddRoomRequest;
import com.sevenStar.hotel.dtos.requests.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.requests.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.response.AddRoomResponse;
import com.sevenStar.hotel.dtos.response.DeleteRoomResponse;
import com.sevenStar.hotel.dtos.response.ReviewAllResponse;
import com.sevenStar.hotel.dtos.response.UpdateRoomResponse;

public interface RoomService {
    AddRoomResponse addRoom(AddRoomRequest room);
    UpdateRoomResponse updateRoom(UpdateRoomRequest room);
    DeleteRoomResponse deleteRoom(DeleteRoomRequest room);
    ReviewAllResponse reviewRooms();
    AddRoomResponse searchByRoomNumber(int roomNumber);
    AddRoomResponse deleteAllRooms();

}
