package com.jun.clover.service

import com.jun.clover.entity.User
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class UserServiceTest (@Autowired private val userService: UserService) {
    // 사용자 등록 테스트
    @Test
    fun userRegister() {
        val test = User("test", "신한", "테스트", 30, "카카오톡", "2020-01-11")
        userService.registerUser(test)
        val testUser = userService.userFindById("test").get()
        assertEquals(testUser.id, test.id)
    }

    // 사용자 정보 수정 테스트
    @Test
    fun userUpdate() {
        val test = User("test", "신한", "테스트", 30, "카카오톡", "2020-01-11")
        userService.registerUser(test)
        test.name = "변경"
        userService.updateUser(test)
        val testUser = userService.userFindById("test").get()
        assertEquals(testUser.name, "변경")
    }

    // 사용자 포인트 추가 테스트
    @Test
    fun userAddPoint() {
        val test = User("test", "신한", "테스트", 30, "카카오톡", "2020-01-11")
        userService.registerUser(test)
        userService.modifyUserPoint("test", 100)
        val testUser = userService.userFindById("test").get()
        assertEquals(testUser.point, 130)
    }
}