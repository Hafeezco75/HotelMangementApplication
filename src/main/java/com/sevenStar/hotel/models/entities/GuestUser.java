package com.sevenStar.hotel.models.entities;

import com.sevenStar.hotel.enums.UserRoles;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@Entity
public class GuestUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private UserRoles role;
    private String Email;

    @OneToMany
    private List<Booking> bookings;
}
