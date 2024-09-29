package com.sevenStar.hotel.services.interfaces;

<<<<<<< HEAD
import org.springframework.stereotype.Service;

@Service
public interface RoomService {
=======
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
>>>>>>> b144de605ce8a8e38e11ff12337c1d1a5e29a8b7

}
