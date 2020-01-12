package com.jun.clover.service

import com.jun.clover.entity.CloverHistory
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.lang.Exception

@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class CloverHistoryServiceTest (@Autowired private val cloverHistoryService: CloverHistoryService) {
    @Test
    @Order(8)
    fun `구매 후 당첨금 증가 테스트`() {
        val before = cloverHistoryService.getTodayClover().prizeClover
        cloverHistoryService.purchaseClover()
        val after = cloverHistoryService.getTodayClover().prizeClover
        assertEquals(after == before + 10, true)
    }

    @Test
    @Order(7)
    // 주의 : 테스트 전 오늘 날짜 클로버를 지우고 테스트할 것
    fun `클로버 회차 추가 테스트`() {
        cloverHistoryService.createCloverHistory()
        val test : CloverHistory? = cloverHistoryService.getTodayClover()
        assertNotNull(test)
    }
}