package com.example.concert_reservation.src.dto

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Payment(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne @JoinColumn(name = "user_id")
    val user: User,
    @ManyToOne @JoinColumn(name = "reservation_id")
    val reservation: Reservation,
    val amount: BigDecimal,
    val status: String,
    val paymentDate: LocalDateTime
)
