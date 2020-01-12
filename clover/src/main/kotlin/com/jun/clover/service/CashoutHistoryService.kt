package com.jun.clover.service

import com.jun.clover.entity.CashoutHistory
import com.jun.clover.repository.CashoutHistoryRepository
import org.springframework.stereotype.Service

@Service
class CashoutHistoryService (private val cashoutHistoryRepository: CashoutHistoryRepository) {
    // 캐시아웃 이력 추가
    fun createCashoutHistory(cashoutHistory: CashoutHistory) = cashoutHistoryRepository.save(cashoutHistory)

    // 유저의 캐시아웃 이력
    fun getCashoutHistoryById(idCashout : String) : List<CashoutHistory>? = cashoutHistoryRepository.findCashoutHistoryByIdCashout(idCashout)

    // 모든 캐시아웃 이력
    fun getAllCashoutHistory(): List<CashoutHistory> = cashoutHistoryRepository.findAll()
}