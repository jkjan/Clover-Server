package com.jun.clover.service

import com.jun.clover.cloverhistory.CloverHistoryService
import com.jun.clover.clovervalid.CloverValidService
import com.jun.clover.user.UserService
import com.jun.clover.variable.Price
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class CloverValidServiceTest (@Autowired private val cloverValidService: CloverValidService,
                                       @Autowired private val cloverHistoryService : CloverHistoryService,
                                       @Autowired private val userService: UserService) {
    @Test
    @Order(5)
    fun `클로버 구매 테스트`() {
        val beforeUser = userService.findUserById("test")
        val beforeCloverHistory = cloverHistoryService.getTodayClover()
        val beforeCloverValid = cloverValidService.getPurchasedCloverList()
        cloverValidService.purchaseClover("test")
        val afterUser = userService.findUserById("test")
        val afterCloverHistory = cloverHistoryService.getTodayClover()
        val afterCloverValid = cloverValidService.getPurchasedCloverList()
        assertEquals(
                (afterUser.get().point == beforeUser.get().point - Price.CLOVER.get()
                        && afterCloverHistory.prizeClover == beforeCloverHistory.prizeClover + Price.CLOVER.get()
                        && afterCloverValid.size == beforeCloverValid.size + 1
                        )
                , true)
    }

    @Test
    @Order(6)
    fun `추첨 완료 후 클로버 전체 삭제 테스트`() {
        cloverValidService.deleteTodayClover()
        val test = cloverValidService.getPurchasedCloverList().size
        assertEquals(test, 0)
    }
}