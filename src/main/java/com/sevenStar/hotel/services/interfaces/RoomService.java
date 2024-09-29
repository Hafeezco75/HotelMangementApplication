package com.sevenStar.hotel.services.interfaces;

import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.response.RoomDTO;

public interface RoomService {
    RoomDTO addRoom(AddRoomRequest room);
    RoomDTO updateRoom(UpdateRoomRequest room);
    RoomDTO deleteRoom(DeleteRoomRequest room);
    RoomDTO reviewRooms();
    RoomDTO searchByRoomNumber(int roomNumber);
    RoomDTO deleteAllRooms();

}
