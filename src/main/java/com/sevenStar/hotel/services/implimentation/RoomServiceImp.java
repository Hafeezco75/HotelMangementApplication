package com.sevenStar.hotel.services.implimentation;


import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.response.RoomDTO;
import com.sevenStar.hotel.exceptions.Exception;
import com.sevenStar.hotel.models.entities.Room;
import com.sevenStar.hotel.models.repositories.RoomRepository;
import com.sevenStar.hotel.services.interfaces.RoomService;
import com.sevenStar.hotel.utilities.RoomMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomServiceImp implements RoomService {

    private final RoomRepository roomRepository;

    @Override
    public RoomDTO addRoom(AddRoomRequest request) {
        if(validateRoomNumber(request.getRoomNumber())){
            Room newRoom = roomRepository.save(RoomMapper.mapper(request));
            return RoomMapper.mapper(newRoom);
        }
        throw new Exception("Invalid Room Number");

    }

    @Override
    public RoomDTO updateRoom(UpdateRoomRequest request) {

        Room foundRoom = findByRoomNumber(request.getOldRoomNumber());
        if (foundRoom != null) {
            Room updatedRoom = RoomMapper.mapper(foundRoom,request);
            return RoomMapper.updatedRoom(roomRepository.save(updatedRoom));
        }
        throw new Exception("Room not found check room number again");

    }

    @Override
    public RoomDTO deleteRoom(DeleteRoomRequest room) {
        RoomDTO response  = new RoomDTO();
        Room foundRoom = findByRoomNumber(room.getRoomNumber());
        if (foundRoom != null) {
            roomRepository.delete(foundRoom);
            response.setMessage("Room deleted successfully");
        }
        return response;
    }

    @Override
    public RoomDTO reviewRooms() {
        RoomDTO reviewRoomResponse = new RoomDTO();
        reviewRoomResponse.setRooms(roomRepository.findAll());
        reviewRoomResponse.setMessage("All Rooms");
        return reviewRoomResponse;

    }

    @Override
    public RoomDTO searchByRoomNumber(int roomNumber) {
        RoomDTO response = new RoomDTO();
        Room foundRoom = findByRoomNumber(roomNumber);
        if(foundRoom != null) {
            response.setFoundRoom(foundRoom);
            return response;
        }
        throw new Exception("Room not found check room number again");
    }

    @Override
    public RoomDTO deleteAllRooms() {
        RoomDTO response = new RoomDTO();
        roomRepository.deleteAll();
        response.setMessage("All Rooms Deleted");
        return response;
    }

    private Room findByRoomNumber(int roomNumber) {
        return  roomRepository.findByRoomNumber(roomNumber);
    }

    private boolean validateRoomNumber(int roomNumber) {
        Room foundRoom = findByRoomNumber(roomNumber);
        return foundRoom == null;
    }
}
