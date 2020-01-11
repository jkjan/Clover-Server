package com.jun.clover.controller

import com.jun.clover.entity.CloverHistory
import com.jun.clover.service.CloverHistoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CloverHistoryController (private val cloverHistoryService : CloverHistoryService) {
    // 클로버 구매 - 당첨금 증가
    @PutMapping(path = ["/clover/history"])
    fun purchaseClover() {
        cloverHistoryService.purchaseClover()
    }

    // 전체 클로버 내역
    @GetMapping(path = ["/clover/history"])
    fun getCloverHistory() : List<CloverHistory> = cloverHistoryService.getCloverHistory()
}