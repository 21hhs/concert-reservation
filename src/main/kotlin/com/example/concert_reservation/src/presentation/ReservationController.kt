package com.example.concert_reservation.src.presentation

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/reservation")
class ReservationController {

    @PostMapping
    fun reserveSeat(
        @RequestBody reservationRequest: ReservationRequest
    ): ReservationResponse {
        return ReservationResponse(
            status = "SUCCESS",
            message = "Seat reserved successfully"
        )
    }
}

data class ReservationRequest(
    val userId: Long,
    val seatId: Long
)

data class ReservationResponse(
    val status: String,
    val message: String
)
