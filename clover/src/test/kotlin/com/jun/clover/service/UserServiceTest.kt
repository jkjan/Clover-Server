package com.jun.clover.service

import com.jun.clover.entity.User
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
internal class UserServiceTest (@Autowired private val userService: UserService) {
    @Test
    @Order(1)
    fun `사용자 등록 테스트`() {
        val test = User("test", "신한", "테스트", 30, "카카오톡", "2020-01-11")
        userService.registerUser(test)
        val testUser = userService.findUserById("test").get()
        assertEquals(testUser.id, test.id)
    }

    @Test
    @Order(2)
    fun `사용자 정보 수정 테스트`() {
        val test = User("test", "신한", "테스트", 30, "카카오톡", "2020-01-11")
        userService.registerUser(test)
        test.name = "변경"
        userService.updateUser(test)
        val testUser = userService.findUserById("test").get()
        assertEquals(testUser.name, "변경")
    }

    @Test
    @Order(3)
    fun `사용자 포인트 변동 테스트`() {
        val test = User("test", "신한", "테스트", 30, "카카오톡", "2020-01-11")
        userService.registerUser(test)
        userService.modifyUserPoint("test", 100)
        val testUser = userService.findUserById("test").get()
        assertEquals(testUser.point, 130)
    }

    @Test
    @Order(4)
    fun `아이디로 사용자 찾기 테스트`() {
        val list = userService.findUserById("test")
        if (list.isEmpty)
            assertTrue(false)
        else {
            assertEquals(list.get().id, "test")
        }
    }
}