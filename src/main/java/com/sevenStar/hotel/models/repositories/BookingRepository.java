package com.sevenStar.hotel.models.repositories;

import com.sevenStar.hotel.models.entities.Booking;
import com.sevenStar.hotel.models.entities.GuestUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByEmail(GuestUser guestUser);

    void deleteById(long id);
}
