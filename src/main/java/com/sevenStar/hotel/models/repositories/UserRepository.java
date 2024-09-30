package com.sevenStar.hotel.models.repositories;

import com.sevenStar.hotel.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
