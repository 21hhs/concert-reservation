package com.example.concert_reservation.src.presentation

import org.springframework.web.bind.annotation.*
import java.math.BigDecimal
import java.time.LocalDateTime

@RestController
@RequestMapping("/api/payment")
class PaymentController {

    @PostMapping
    fun processPayment(
        @RequestBody paymentRequest: PaymentRequest
    ): PaymentResponse {
        return PaymentResponse(
            status = "SUCCESS",
            amount = paymentRequest.amount,
            paymentDate = LocalDateTime.now()
        )
    }
}

data class PaymentRequest(
    val userId: Long,
    val reservationId: Long,
    val amount: BigDecimal
)

data class PaymentResponse(
    val status: String,
    val amount: BigDecimal,
    val paymentDate: LocalDateTime
)
