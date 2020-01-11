package com.jun.clover.controller

import com.jun.clover.service.CloverHistoryService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class CloverHistoryController (private val cloverHistoryService : CloverHistoryService) {
    @PostMapping(path = ["/clover/history"])
    fun purchaseClover() {
        cloverHistoryService.purchaseClover()
    }
}