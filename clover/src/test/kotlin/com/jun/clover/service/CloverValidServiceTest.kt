package com.jun.clover.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class CloverValidServiceTest (@Autowired private val cloverValidService: CloverValidService) {
    @Test
    fun purchaseClover() {
        cloverValidService.purchaseClover("test")
        cloverValidService.purchaseClover("test2")
        val testClover = cloverValidService.getPurchasedCloverList()
        val a = testClover[testClover.size-1].cloverNum
        val b = testClover[testClover.size-2].cloverNum
        assertEquals(a > b, true)
    }

    @Test
    fun deleteTodayClover() {
        cloverValidService.deleteTodayClover()
        val test = cloverValidService.getPurchasedCloverList().size
        assertEquals(test, 0)
    }
}