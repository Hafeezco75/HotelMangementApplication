package com.sevenStar.hotel.models.repositories;

import com.sevenStar.hotel.enums.RoomTypes;
import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.entities.GuestUser;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
import java.util.List;


public interface BookingRepository extends JpaRepository<Booking, Long> {

    Booking findByRoomTypeAndBookingID(RoomTypes roomType, Long bookingID);
=======
>>>>>>> b144de605ce8a8e38e11ff12337c1d1a5e29a8b7

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
=======
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByEmail(GuestUser guestUser);

    void deleteById(long id);
}
