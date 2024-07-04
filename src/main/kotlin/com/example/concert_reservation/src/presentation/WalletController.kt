package com.example.concert_reservation.src.presentation

import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@RestController
@RequestMapping("/api/wallet")
class WalletController {

    @GetMapping("/balance")
    fun getBalance(
        @RequestParam userId: Long
    ): WalletResponse {
        return WalletResponse(balance = BigDecimal("100.00"))
    }

    @PostMapping("/charge")
    fun chargeWallet(
        @RequestBody chargeRequest: ChargeRequest
    ): WalletResponse {
        return WalletResponse(balance = BigDecimal("200.00"))
    }
}

data class WalletResponse(
    val balance: BigDecimal
)

data class ChargeRequest(
    val userId: Long,
    val amount: BigDecimal
)
