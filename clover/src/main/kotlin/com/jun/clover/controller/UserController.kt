package com.jun.clover.controller

import com.jun.clover.entity.User
import com.jun.clover.service.UserService
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

@RestController
class UserController (private val userService: UserService) {
    // 사용자 등록 (회원 가입)
    @PostMapping(path = ["/user"])
    fun userRegister(@Valid @NotNull @RequestBody user : User) {
        userService.userRegister(user)
    }

    // 사용자 리스트
    @GetMapping(path = ["/user"])
    fun userList() : List<User> = userService.userList()

    // 사용자 정보 수정
    @PutMapping(path = ["/user/{id}"])
    fun userUpdate(@PathVariable ("id") id : String, @Valid @NotNull @RequestBody user : User) {
        userService.userUpdate(user)
    }

    // 포인트 증가/감소
    @PutMapping(path = ["/user/{id}/point/{add}"])
    fun userAddPoint(@PathVariable ("id") id : String, @PathVariable("add") add : Int) {
        userService.userModifyPoint(id, add)
    }
}