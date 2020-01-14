package com.jun.clover.cashouthistory

import com.jun.clover.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Exception

@Service
class CashoutHistoryService (private val cashoutHistoryRepository: CashoutHistoryRepository,
                             private val userRepository: UserRepository) {
    // 캐시아웃 이력 추가
    @Transactional(rollbackFor = [Exception::class])
    fun createCashoutHistory(cashoutHistory: CashoutHistory) {
        userRepository.modifyPoint(cashoutHistory.idCashout, -cashoutHistory.amountCashout)
        cashoutHistoryRepository.save(cashoutHistory)
    }

    // 유저의 캐시아웃 이력
    fun getCashoutHistoryById(idCashout : String) : List<CashoutHistory> = cashoutHistoryRepository.findCashoutHistoryByIdCashout(idCashout)

    // 모든 캐시아웃 이력
    fun getAllCashoutHistory(): List<CashoutHistory> = cashoutHistoryRepository.findAll()
}