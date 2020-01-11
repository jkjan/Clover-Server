package com.jun.clover.service

import com.jun.clover.entity.User
import com.jun.clover.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService (private val userRepository: UserRepository){
    // 사용자 등록 (회원 가입)
    fun userRegister(user : User) = userRepository.save(user)

    // 아이디로 사용자 찾기
    fun userFindById(id: String) = userRepository.findById(id)

    // 사용자 리스트
    fun userList(): List<User> = userRepository.findAll()

    // 사용자 정보 수정
    fun userUpdate(user : User) = userRepository.save(user)

    // 포인트 증가/감소
    fun userModifyPoint(id : String, add : Int) = userRepository.modifyPoint(id, add)
}