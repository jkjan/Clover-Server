package com.jun.clover.user

import com.jun.clover.cashouthistory.CashoutHistoryRepository
import com.jun.clover.cloverhistory.CloverHistory
import com.jun.clover.cloverhistory.CloverHistoryRepository
import com.jun.clover.clovervalid.CloverValid
import com.jun.clover.clovervalid.CloverValidRepository
import com.jun.clover.user.User
import com.jun.clover.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (private val userRepository: UserRepository) {

    // 사용자 등록 (회원 가입)
    fun registerUser(user : User) = userRepository.save(user)

    // 사용자 리스트
    fun getUserList(): List<User> = userRepository.findAll()

    // 사용자 정보 수정
    fun updateUser(user : User) = userRepository.save(user)

    // 사용자 삭제
    fun deleteUserById(id : String) = userRepository.deleteById(id)

    // 포인트 증가/감소 (광고 클릭)
   // fun modifyUserPoint(id : String, add : Int) = userRepository.modifyPoint(id, add)

    // 아이디로 사용자 찾기
    fun findUserById(id: String) = userRepository.findById(id)
}