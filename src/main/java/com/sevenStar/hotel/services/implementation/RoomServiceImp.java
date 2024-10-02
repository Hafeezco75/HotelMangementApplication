package com.sevenStar.hotel.services.implementation;


import com.sevenStar.hotel.dtos.requests.AddRoomRequest;
import com.sevenStar.hotel.dtos.requests.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.requests.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.response.AddRoomResponse;
import com.sevenStar.hotel.dtos.response.DeleteRoomResponse;
import com.sevenStar.hotel.dtos.response.ReviewAllResponse;
import com.sevenStar.hotel.dtos.response.UpdateRoomResponse;
import com.sevenStar.hotel.enums.RoomTypes;
import com.sevenStar.hotel.exceptions.Exception;
import com.sevenStar.hotel.exceptions.RoomNotFoundException;
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
    public AddRoomResponse addRoom(AddRoomRequest request) {
        RoomTypes room = RoomTypes.fromString(request.getRoomType());
        if (validateRoomNumber(request.getRoomNumber())) {
            Room newRoom = roomRepository.save(RoomMapper.mapper(request));
            return RoomMapper.mapper(newRoom);
        }
        throw new Exception("Invalid Room Number");

    }

    @Override
    public UpdateRoomResponse updateRoom(UpdateRoomRequest request) {

        Room foundRoom = findByRoomById(request.getRoomId());
        if (foundRoom != null) {
            Room updatedRoom = RoomMapper.mapper(foundRoom, request);
            return RoomMapper.updatedRoom(roomRepository.save(updatedRoom));
        }
        throw new Exception("Room not found check room number again");

    }

    @Override
    public DeleteRoomResponse deleteRoom(DeleteRoomRequest room) {
        DeleteRoomResponse response = new DeleteRoomResponse();
        Room foundRoom = findByRoomNumber(room.getRoomNumber());
        if (foundRoom != null) {
            roomRepository.delete(foundRoom);
            response.setMessage("Room deleted successfully");
        }
        return response;
    }

    @Override
    public ReviewAllResponse reviewRooms() {

        ReviewAllResponse reviewRoomResponse = new ReviewAllResponse();
        reviewRoomResponse.setRooms(roomRepository.findAll());
        reviewRoomResponse.setMessage("All Rooms");
        return reviewRoomResponse;

    }

    @Override
    public AddRoomResponse searchByRoomNumber(int roomNumber) {

        Room foundRoom = findByRoomNumber(roomNumber);
        if (foundRoom != null) {
            return RoomMapper.foundRoom(foundRoom);
        }
        throw new RoomNotFoundException("Room not found check room number again");
    }

    @Override
    public AddRoomResponse deleteAllRooms() {
        AddRoomResponse response = new AddRoomResponse();
        roomRepository.deleteAll();
        response.setMessage("All Rooms Deleted");
        return response;
    }

    private Room findByRoomNumber(int roomNumber) {
        return roomRepository.findByRoomNumber(roomNumber);
    }

    private Room findByRoomById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException("Room not found check id again"));
    }

    private boolean validateRoomNumber(int roomNumber) {
        Room foundRoom = findByRoomNumber(roomNumber);
        return foundRoom == null;
    }
}