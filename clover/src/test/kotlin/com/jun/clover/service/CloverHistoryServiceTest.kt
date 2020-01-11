package com.jun.clover.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class CloverHistoryServiceTest (@Autowired private val cloverHistoryService: CloverHistoryService) {
    @Test
    fun purchaseClover() {
        val before = cloverHistoryService.todayClover().prizeClover
        cloverHistoryService.purchaseClover()
        val after = cloverHistoryService.todayClover().prizeClover
        assertEquals(after == before + 10, true)
    }
}