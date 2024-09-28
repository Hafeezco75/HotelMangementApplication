package com.sevenStar.hotel.models.repositories;

import com.sevenStar.hotel.models.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
