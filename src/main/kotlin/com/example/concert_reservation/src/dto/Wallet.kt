package com.example.concert_reservation.src.dto

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
data class Wallet(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne @JoinColumn(name = "user_id")
    val user: User,
    val balance: BigDecimal,
    val updatedAt: LocalDateTime
)
