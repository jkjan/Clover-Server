package com.jun.clover.service

import com.jun.clover.entity.CashoutHistory
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class CashoutHistoryServiceTest(@Autowired private val cashoutHistoryService: CashoutHistoryService) {
    @Test
    @Order(9)
    fun `캐시아웃 후 캐시아웃 횟수, 시간 자동 입력 테스트`() {
        val before = cashoutHistoryService.getAllCashoutHistory()
        cashoutHistoryService.createCashoutHistory(CashoutHistory("test", 100))
        val after = cashoutHistoryService.getAllCashoutHistory()
        assertTrue(after.size == before.size + 1
                && after[after.size - 1].idCashout == "test"
                && after[after.size - 1].cashoutNum > after[after.size - 2].cashoutNum)
    }

    @Test
    @Order(10)
    fun `캐시아웃 아이디로 찾기 테스트`() {
        val test = cashoutHistoryService.getCashoutHistoryById("test")
        var flag = true
        if (test != null) {
            for (i in test.indices) {
                if (test[i].idCashout != "test") {
                    flag = false
                }
            }
            assertTrue(flag)
        }
        else {
            assertTrue(true)
        }
    }
}