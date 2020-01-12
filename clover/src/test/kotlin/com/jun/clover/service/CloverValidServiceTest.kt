package com.jun.clover.service

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
internal class CloverValidServiceTest (@Autowired private val cloverValidService: CloverValidService) {
    @Test
    @Order(5)
    fun `클로버 구매, 클로버 번호, 구매 시간 자동 증가 테스트`() {
        cloverValidService.purchaseClover("test")
        cloverValidService.purchaseClover("test2")
        val testClover = cloverValidService.getPurchasedCloverList()
        val a = testClover[testClover.size-1].cloverNum
        val b = testClover[testClover.size-2].cloverNum
        assertEquals(a > b, true)
    }

    @Test
    @Order(6)
    fun `추첨 완료 후 클로버 전체 삭제 테스트`() {
        cloverValidService.deleteTodayClover()
        val test = cloverValidService.getPurchasedCloverList().size
        assertEquals(test, 0)
    }
}