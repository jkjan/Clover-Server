package com.jun.clover.controller

import com.jun.clover.entity.User
import com.jun.clover.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

@RestController
class UserController (private val userService: UserService) {
    // 사용자 등록 (회원 가입)
    @PostMapping(path = ["/user"])
    fun registerUser(@Valid @NotNull @RequestBody user : User) = userService.registerUser(user)

    // 사용자 리스트
    @GetMapping(path = ["/user"])
    fun getUserList() : List<User> = userService.getUserList()

    // 사용자 정보 수정
    @PutMapping(path = ["/user/{id}"])
    fun updateUser(@PathVariable ("id") id : String, @Valid @NotNull @RequestBody user : User) = userService.updateUser(user)

    // 포인트 증가/감소
    @PutMapping(path = ["/user/{id}/point/{modify}"])
    fun modifyUserPoint(@PathVariable ("id") id : String, @PathVariable("modify") add : Int) = userService.modifyUserPoint(id, add)
}