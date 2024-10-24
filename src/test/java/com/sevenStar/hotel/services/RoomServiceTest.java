package com.sevenStar.hotel.services;


import com.sevenStar.hotel.dtos.request.AddRoomRequest;
import com.sevenStar.hotel.dtos.request.DeleteRoomRequest;
import com.sevenStar.hotel.dtos.request.UpdateRoomRequest;
import com.sevenStar.hotel.dtos.response.AddRoomResponse;
import com.sevenStar.hotel.dtos.response.DeleteRoomResponse;
import com.sevenStar.hotel.dtos.response.ReviewAllResponse;
import com.sevenStar.hotel.dtos.response.UpdateRoomResponse;
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
        request.setRoomType("DELUXE");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(5667);
        AddRoomResponse room = roomService.addRoom(request);
        assertEquals(1,roomService.reviewRooms().getRooms().size());
        assertEquals("DELUXE",room.getRoomType());

    }

    @Test
    public void testThatTwoRoomIsAddedAndCanBeViewed() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomType("EXECUTIVE");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(419);
        roomService.addRoom(request);
        AddRoomRequest request2 = new AddRoomRequest();
        request2.setRoomType("STANDARD");
        request2.setDescription("The Room is a flat and suitable for extended family");
        request2.setRoomPrice(BigDecimal.valueOf(30000));
        request2.setRoomImage("HouseImageURL");
        request2.setRoomNumber(911);
        AddRoomResponse roomTwo = roomService.addRoom(request2);
        assertEquals("STANDARD",roomTwo.getRoomType());
        ReviewAllResponse allRooms = roomService.reviewRooms();
        assertEquals(2,allRooms.getRooms().size());

    }
    @Test
    public void testThatRoomsIsAddedAndCanAllBeDeleted() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomType("DUPLEX");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(419);
        roomService.addRoom(request);
        AddRoomRequest request2 = new AddRoomRequest();
        request2.setRoomType("EXECUTIVE");
        request2.setDescription("The Room is a flat and suitable for extended family");
        request2.setRoomPrice(BigDecimal.valueOf(30000));
        request2.setRoomImage("HouseImageURL");
        request2.setRoomNumber(911);
        roomService.addRoom(request2);
        AddRoomResponse response = roomService.deleteAllRooms();
        assertEquals(0, roomService.reviewRooms().getRooms().size());
        assertEquals("All Rooms Deleted",response.getMessage());
    }
    @Test
    public void testThatTwoRoomIsAddedAndOneCanBeDeleted() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomType("DUPLEX");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(419);
        AddRoomResponse room = roomService.addRoom(request);
        AddRoomRequest request2 = new AddRoomRequest();
        request2.setRoomType("STANDARD");
        request2.setDescription("The Room is a flat and suitable for extended family");
        request2.setRoomPrice(BigDecimal.valueOf(30000));
        request2.setRoomImage("HouseImageURL");
        request2.setRoomNumber(911);
        roomService.addRoom(request2);
        DeleteRoomRequest request3 = new DeleteRoomRequest();
        request3.setRoomNumber(room.getRoomNumber());
        DeleteRoomResponse response = roomService.deleteRoom(request3);
        assertEquals(1, roomService.reviewRooms().getRooms().size());
        assertEquals("Room deleted successfully", response.getMessage());
    }

    @Test
    public void testThatParticularApartmentCanBeSearchedForByRoomNumber() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomType("DUPLEX");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(419);
        AddRoomResponse addedRoom = roomService.addRoom(request);
        AddRoomRequest request2 = new AddRoomRequest();
        request2.setRoomType("STANDARD");
        request2.setDescription("The Room is a flat and suitable for extended family");
        request2.setRoomPrice(BigDecimal.valueOf(30000));
        request2.setRoomImage("HouseImageURL");
        request2.setRoomNumber(911);
        roomService.addRoom(request2);
        AddRoomResponse FoundRoom = roomService.searchByRoomNumber(addedRoom.getRoomNumber());
        assertEquals("DUPLEX",FoundRoom.getRoomType());
        assertEquals(419,FoundRoom.getRoomNumber());
    }

    @Test
    public void testThatAnApartmentDetailCanBeUpdated() {
        AddRoomRequest request = new AddRoomRequest();
        request.setRoomType("STANDARD");
        request.setDescription("The Room is a duplex and relaxing");
        request.setRoomPrice(BigDecimal.valueOf(90000));
        request.setRoomImage("imageURL");
        request.setRoomNumber(419);
        AddRoomResponse addedRoom = roomService.addRoom(request);
        UpdateRoomRequest request2 = new UpdateRoomRequest();
        request2.setId(addedRoom.getRoomId());
        request2.setRoomNumber(2024);
        request2.setType("EXECUTIVE");
        request2.setDescription("The Room is a flat and suitable for extended family");
        request2.setPrice(BigDecimal.valueOf(700000));
        request2.setAvailable(false);
        request2.setImage("glow");
        UpdateRoomResponse updatedRoom = roomService.updateRoom(request2);
        System.out.println(addedRoom);
        System.out.println(updatedRoom);
        assertEquals(2024,updatedRoom.getRoomNumber());
        assertEquals("EXECUTIVE",updatedRoom.getType());
        assertEquals(1,roomService.reviewRooms().getRooms().size());
    }

}
