package com.example.concert_reservation.src.dto

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Queue(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @ManyToOne @JoinColumn(name = "user_id")
    val user: User,
    val token: String,
    val issuedAt: LocalDateTime,
    val expiredAt: LocalDateTime
)