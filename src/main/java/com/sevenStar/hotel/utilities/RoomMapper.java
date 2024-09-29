package com.sevenStar.hotel.utilities;


import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.response.AddRoomResponse;
import com.sevenStar.hotel.dtos.response.UpdateRoomResponse;
import com.sevenStar.hotel.models.entities.Room;

public class RoomMapper {

    public static Room mapper(AddRoomRequest request) {
        Room room = new Room();
        room.setDescription(request.getDescription());
        room.setRoomPrice(request.getRoomPrice());
        room.setRoomImage(request.getRoomImage());
        room.setRoomType(request.getRoomType());
        room.setRoomNumber(request.getRoomNumber());
        room.setRoomAvailable(true);
        return room;
    }
    public static AddRoomResponse mapper(Room room) {
        AddRoomResponse roomDTO = new AddRoomResponse();
        roomDTO.setRoomId(room.getRoomId());
        roomDTO.setDescription(room.getDescription());
        roomDTO.setRoomPrice(room.getRoomPrice());
        roomDTO.setRoomImage(room.getRoomImage());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setRoomAvailable(true);
        roomDTO.setRoomNumber(room.getRoomNumber());
        roomDTO.setMessage(room.getRoomType() + " Room  created successfully");
        return roomDTO;
    }

    public static Room mapper(Room foundRoom, UpdateRoomRequest request) {
        foundRoom.setRoomId(request.getId());
        foundRoom.setRoomNumber(request.getRoomNumber());
        foundRoom.setDescription(request.getDescription());
        foundRoom.setRoomPrice(request.getPrice());
        foundRoom.setRoomAvailable(request.isAvailable());
        foundRoom.setRoomImage(request.getImage());
        foundRoom.setRoomType(request.getType());
        return foundRoom;
    }

    public static UpdateRoomResponse updatedRoom(Room foundRoom) {
        UpdateRoomResponse roomDTO = new UpdateRoomResponse();
        roomDTO.setRoomId(foundRoom.getRoomId());
        roomDTO.setRoomNumber(foundRoom.getRoomNumber());
        roomDTO.setDescription(foundRoom.getDescription());
        roomDTO.setPrice(foundRoom.getRoomPrice());
        roomDTO.setAvailable(foundRoom.isRoomAvailable());
        roomDTO.setImage(foundRoom.getRoomImage());
        roomDTO.setType(foundRoom.getRoomType());

        return roomDTO;
    }

    public static AddRoomResponse foundRoom(Room foundRoom) {
        AddRoomResponse response = new AddRoomResponse();
        response.setRoomPrice(foundRoom.getRoomPrice());
        response.setRoomNumber(foundRoom.getRoomNumber());
        response.setMessage("Room found");
        response.setRoomImage(foundRoom.getRoomImage());
        response.setDescription(foundRoom.getDescription());
        response.setRoomType(foundRoom.getRoomType());
        response.setRoomAvailable(foundRoom.isRoomAvailable());
        response.setRoomId(foundRoom.getRoomId());
        return response;
    }
}
