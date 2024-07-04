package com.example.concert_reservation.src.presentation

import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/queue")
class QueueController {

    @PostMapping("/token")
    fun issueToken(
        @RequestBody userId: Long
    ): TokenResponse {
        return TokenResponse(
            token = "mock-token",
            issuedAt = LocalDateTime.now(),
            expiredAt = LocalDateTime.now().plusHours(1)
        )
    }

    @GetMapping("/info")
    fun getQueueInfo(
        @RequestParam token: String)
    : QueueInfoResponse {
        return QueueInfoResponse(
            status = "IN_QUEUE",
            position = 1
        )
    }
}

data class TokenResponse(
    val token: String,
    val issuedAt: LocalDateTime,
    val expiredAt: LocalDateTime
)

data class QueueInfoResponse(
    val status: String,
    val position: Int
)