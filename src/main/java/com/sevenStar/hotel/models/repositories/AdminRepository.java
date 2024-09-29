package com.sevenStar.hotel.models.repositories;

import com.sevenStar.hotel.models.entities.AdminUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminUser, Long> {
}
