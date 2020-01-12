package com.jun.clover.controller

import com.jun.clover.entity.CashoutHistory
import com.jun.clover.service.CashoutHistoryService
import com.sun.istack.NotNull
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
class CashoutHistoryController (private val cashoutHistoryService: CashoutHistoryService) {
    // 캐시아웃 추가
    @PostMapping(path = ["/cashout"])
    fun createCashoutHistory(@Valid @NotNull @RequestBody cashoutHistory : CashoutHistory) {
        cashoutHistoryService.createCashoutHistory(cashoutHistory)
    }

    // 유저의 캐시아웃 이력
    @GetMapping(path = ["/cashout/{id_cashout}"])
    fun getCashoutHistoryById(@PathVariable(name = "id_cashout") id_cashout : String)
    = cashoutHistoryService.getCashoutHistoryById(id_cashout)

    // 전체 캐시아웃 이력
    @GetMapping(path = ["/cashout"])
    fun getAllCashoutHistory() = cashoutHistoryService.getAllCashoutHistory()
}