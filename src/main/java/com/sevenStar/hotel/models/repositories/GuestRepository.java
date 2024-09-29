package com.sevenStar.hotel.models.repositories;

import com.sevenStar.hotel.models.entities.GuestUser;
import org.springframework.data.jpa.repository.JpaRepository;


public interface GuestRepository extends JpaRepository<GuestUser,Long> {
    GuestUser findByEmail(String email);


}
