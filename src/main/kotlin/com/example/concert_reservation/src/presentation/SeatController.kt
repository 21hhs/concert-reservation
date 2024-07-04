package com.example.concert_reservation.src.presentation

import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/api/seat")
class SeatController {

    @GetMapping("/dates")
    fun getAvailableDates(): List<LocalDate> {
        return listOf(
            LocalDate.now(),
            LocalDate.now().plusDays(1),
            LocalDate.now().plusDays(2)
        )
    }

    @GetMapping("/{date}")
    fun getAvailableSeats(
        @PathVariable date: LocalDate
    ): List<SeatResponse> {
        return listOf(
            SeatResponse(
                seatNumber = "A1",
                isAvailable = true
            ), SeatResponse(
                seatNumber = "A2",
                isAvailable = true
            ))
    }
}

data class SeatResponse(
    val seatNumber: String,
    val isAvailable: Boolean
)
