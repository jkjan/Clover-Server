package com.jun.clover.service

import com.jun.clover.entity.CloverHistory
import com.jun.clover.repository.CloverHistoryRepository
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

@Service
class CloverHistoryService (private val cloverHistoryRepository: CloverHistoryRepository) {
    // 당첨금 증가
    fun purchaseClover() = cloverHistoryRepository.updatePrize()

    // 오늘의 클로버 정보 (날짜, 당첨금 등)
    fun todayClover() : CloverHistory {
        return cloverHistoryRepository.findCloverHistoryByDateClover(LocalDate.now().toString())
    }

    // 전체 클로버 정보
    fun getCloverHistory() : List<CloverHistory> = cloverHistoryRepository.findAll()
}