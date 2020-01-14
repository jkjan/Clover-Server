package com.jun.clover.service

import com.jun.clover.cashouthistory.CashoutHistoryService
import com.jun.clover.cashouthistory.CashoutHistory
import com.jun.clover.user.UserService
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
internal class CashoutHistoryServiceTest(@Autowired private val cashoutHistoryService: CashoutHistoryService,
                                         @Autowired private val userService: UserService) {
    @Test
    @Order(9)
    fun `캐시아웃 테스트`() {
        val beforeUser = userService.findUserById("test")
        val beforeCashoutHistory = cashoutHistoryService.getAllCashoutHistory()
        cashoutHistoryService.createCashoutHistory(CashoutHistory("test", 30))
        val afterUser = userService.findUserById("test")
        val afterCashoutHistory = cashoutHistoryService.getAllCashoutHistory()

        assertEquals(
                (afterUser.get().point == beforeUser.get().point - 30
                        && afterCashoutHistory.size == beforeCashoutHistory.size + 1
                        && afterCashoutHistory.last().idCashout == "test")
                , true
        )
    }

    @Test
    @Order(10)
    fun `캐시아웃 아이디로 찾기 테스트`() {
        val test = cashoutHistoryService.getCashoutHistoryById("test")
        if (test.isEmpty())
            assertTrue(true)
        else {
            for (i in test.indices) {
                if (test[i].idCashout != "test") {
                    assertTrue(false)
                }
            }
            assertTrue(true)
        }
    }
}