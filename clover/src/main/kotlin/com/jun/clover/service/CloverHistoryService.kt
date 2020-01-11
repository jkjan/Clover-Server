package com.jun.clover.service

import com.jun.clover.entity.CloverHistory
import com.jun.clover.repository.CloverHistoryRepository
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

@Service
class CloverHistoryService (private val cloverHistoryRepository: CloverHistoryRepository) {
    fun purchaseClover() = cloverHistoryRepository.updatePrize()

    fun todayClover() : CloverHistory {
        return cloverHistoryRepository.findCloverHistoryByDateClover(LocalDate.now().toString())[0]
    }
}