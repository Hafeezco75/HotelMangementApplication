package com.sevenStar.hotel.models.entities;

import com.sevenStar.hotel.enums.UserRoles;
import jakarta.persistence.*;

import java.util.List;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoles role;
    private String email;
    private String phoneNumber;
    private boolean isLogin;

    @OneToMany
    private List<Booking> bookings;
}
