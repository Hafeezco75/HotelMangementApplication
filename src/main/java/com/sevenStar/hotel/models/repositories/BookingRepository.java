package com.sevenStar.hotel.models.repositories;

import com.sevenStar.hotel.models.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {


}
