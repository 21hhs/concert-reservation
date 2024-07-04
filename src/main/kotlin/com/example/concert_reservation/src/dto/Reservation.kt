package com.example.concert_reservation.src.dto

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Reservation(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne @JoinColumn(name = "user_id")
    val user: User,
    @ManyToOne @JoinColumn(name = "seat_id")
    val seat: Seat,
    val reservationDate: LocalDateTime,
    val isConfirmed: Boolean
)