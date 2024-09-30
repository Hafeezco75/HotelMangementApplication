package com.sevenStar.hotel.utilities;


import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.response.RoomDTO;
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
    public static RoomDTO mapper(Room room) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomId(room.getRoomId());
        roomDTO.setDescription(room.getDescription());
        roomDTO.setRoomPrice(room.getRoomPrice());
        roomDTO.setRoomImage(room.getRoomImage());
        roomDTO.setRoomType(room.getRoomType());
        roomDTO.setRoomAvailable(true);
        roomDTO.setRoomNumber(room.getRoomNumber());
        return roomDTO;
    }

    public static Room mapper(Room foundRoom, UpdateRoomRequest request) {
        foundRoom.setRoomNumber(request.getNewRoomNumber());
        foundRoom.setDescription(request.getDescription());
        foundRoom.setRoomPrice(request.getPrice());
        foundRoom.setRoomAvailable(request.isAvailable());
        foundRoom.setRoomImage(request.getImage());
        foundRoom.setRoomType(request.getType());
        return foundRoom;
    }

    public static RoomDTO updatedRoom(Room foundRoom) {
        RoomDTO roomDTO = new RoomDTO();
        roomDTO.setRoomNumber(foundRoom.getRoomNumber());
        roomDTO.setDescription(foundRoom.getDescription());
        roomDTO.setRoomPrice(foundRoom.getRoomPrice());
        roomDTO.setRoomAvailable(foundRoom.isRoomAvailable());
        roomDTO.setRoomImage(foundRoom.getRoomImage());
        roomDTO.setRoomType(foundRoom.getRoomType());
        return roomDTO;
    }
}
