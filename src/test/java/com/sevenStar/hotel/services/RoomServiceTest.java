package com.sevenStar.hotel.services;


import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.response.RoomDTO;
import com.sevenStar.hotel.services.interfaces.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @BeforeEach
    public void setUp() {
        roomService.deleteAllRooms();
    }
    @Test
    public void testThatNoAddedRoom() {
        assertEquals(0,roomService.reviewRooms().getRooms().size());

    }
    @Test
    public void testThatOneRoomIsAdded() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomName("family-size");
        request.setRoomType("Executive");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(5667);
        RoomDTO room = roomService.addRoom(request);
        assertEquals(1,roomService.reviewRooms().getRooms().size());
        assertEquals("family-size",room.getRoomName());

    }

    @Test
    public void testThatTwoRoomIsAddedAndCanBeViewed() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomName("family-size");
        request.setRoomType("Executive");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(419);
        roomService.addRoom(request);
        AddRoomRequest request2 = new AddRoomRequest();
        request2.setRoomName("Kings");
        request2.setRoomType("Standard");
        request2.setDescription("The Room is a flat and suitable for extended family");
        request2.setRoomPrice(BigDecimal.valueOf(30000));
        request2.setRoomImage("HouseImageURL");
        request2.setRoomNumber(911);
        RoomDTO roomTwo = roomService.addRoom(request2);
        assertEquals("Kings",roomTwo.getRoomName());
        RoomDTO allRooms = roomService.reviewRooms();
        assertEquals(2,allRooms.getRooms().size());

    }
    @Test
    public void testThatRoomsIsAddedAndCanAllBeDeleted() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomName("family-size");
        request.setRoomType("Duplex");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(419);
        roomService.addRoom(request);
        AddRoomRequest request2 = new AddRoomRequest();
        request2.setRoomName("Kings");
        request2.setRoomType("Executive");
        request2.setDescription("The Room is a flat and suitable for extended family");
        request2.setRoomPrice(BigDecimal.valueOf(30000));
        request2.setRoomImage("HouseImageURL");
        request2.setRoomNumber(911);
        roomService.addRoom(request2);
        RoomDTO response = roomService.deleteAllRooms();
        assertEquals(0, roomService.reviewRooms().getRooms().size());
        assertEquals("All Rooms Deleted",response.getMessage());
    }
    @Test
    public void testThatTwoRoomIsAddedAndOneCanBeDeleted() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomName("family-size");
        request.setRoomType("Duplex");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(419);
        RoomDTO room = roomService.addRoom(request);
        AddRoomRequest request2 = new AddRoomRequest();
        request2.setRoomName("Kings");
        request2.setRoomType("Classical");
        request2.setDescription("The Room is a flat and suitable for extended family");
        request2.setRoomPrice(BigDecimal.valueOf(30000));
        request2.setRoomImage("HouseImageURL");
        request2.setRoomNumber(911);
        roomService.addRoom(request2);
        DeleteRoomRequest request3 = new DeleteRoomRequest();
        request3.setRoomNumber(room.getRoomNumber());
        RoomDTO response = roomService.deleteRoom(request3);
        assertEquals(1, roomService.reviewRooms().getRooms().size());
        assertEquals("Room deleted successfully", response.getMessage());
    }

    @Test
    public void testThatParticularApartmentCanBeSearchedForByRoomNumber() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomName("family-size");
        request.setRoomType("Duplex");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(419);
        RoomDTO addedRoom = roomService.addRoom(request);
        AddRoomRequest request2 = new AddRoomRequest();
        request2.setRoomName("Kings");
        request2.setRoomType("Standard");
        request2.setDescription("The Room is a flat and suitable for extended family");
        request2.setRoomPrice(BigDecimal.valueOf(30000));
        request2.setRoomImage("HouseImageURL");
        request2.setRoomNumber(911);
        roomService.addRoom(request2);
        RoomDTO FoundRoom = roomService.searchByRoomNumber(addedRoom.getRoomNumber());
        assertEquals(419,FoundRoom.getFoundRoom().getRoomNumber());
    }

    @Test
    public void testThatAnApartmentDetailCanBeUpdated() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomName("family-size");
        request.setRoomType("Classical");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(419);
        RoomDTO addedRoom = roomService.addRoom(request);
        UpdateRoomRequest request2 = new UpdateRoomRequest();
        request2.setOldRoomNumber(419);
        request2.setNewRoomNumber(2024);
        request2.setName("Kings");
        request2.setType("Executive");
        request2.setDescription("The Room is a flat and suitable for extended family");
        request2.setPrice(BigDecimal.valueOf(700000));
        RoomDTO updatedRoom = roomService.updateRoom(request2);
        System.out.println(addedRoom);
        System.out.println(updatedRoom);
        assertEquals(2024,updatedRoom.getRoomNumber());
        assertEquals("Kings",updatedRoom.getRoomName());
        assertEquals(1,roomService.reviewRooms().getRooms().size());
    }

}
