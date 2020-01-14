package com.jun.clover.service

import com.jun.clover.cloverhistory.CloverHistory
import com.jun.clover.cloverhistory.CloverHistoryService
import com.jun.clover.user.UserService
import org.junit.jupiter.api.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class CloverHistoryServiceTest (@Autowired private val cloverHistoryService: CloverHistoryService,
                                         @Autowired private val userService: UserService) {
    @Test
    @Order(8)
    fun `유저 당첨`() {
        val beforeCloverHistory = cloverHistoryService.getTodayClover()
        val beforeUser = userService.findUserById("test")
        cloverHistoryService.weGotWinnerHere("test")
        val afterCloverHistory = cloverHistoryService.getTodayClover()
        val afterUser = userService.findUserById("test")
        assertEquals(
                (afterCloverHistory.idClover == "test"
                        && afterUser.get().point == beforeUser.get().point + beforeCloverHistory.prizeClover)
                , true
        )
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