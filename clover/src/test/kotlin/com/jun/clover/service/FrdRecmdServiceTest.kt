package com.jun.clover.service

import com.jun.clover.repository.FrdRecmdRepository
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
internal class FrdRecmdServiceTest (@Autowired private val frdRecmdService: FrdRecmdService,
                                    @Autowired private val frdRecmdRepository: FrdRecmdRepository) {
    @Test
    @Order(11)
    fun `추천인 코드 생성 테스트`() {
        val before = frdRecmdService.getAllRecmdList().size
        frdRecmdService.createFrdRecmd("test")
        val after = frdRecmdService.getAllRecmdList().size
        assertTrue(after == before + 1)
    }

    @Test
    @Order(12)
    fun `내가 추천한 사람 목록 테스트`() {
        val test = frdRecmdService.getRecmdeeList("test")
        if (test.isEmpty())
            assertTrue(false)
        else {
            for (i in test.indices) {
                if (test[i].idRecmder != "test")
                    assertTrue(false)
            }
            assertTrue(true)
        }
    }

    @Test
    @Order(13)
    fun `추천인 코드로 추천인 매칭`() {
        val idRecmder = frdRecmdService.matchRecmderByCode("IJVCID", "test3")
        if (idRecmder != null) {
            println(idRecmder)
            assertEquals(frdRecmdRepository.findById("IJVCID").get().idRecmdee, "test3")
        }
        else
            assertTrue(true)
    }
}