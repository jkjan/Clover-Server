package com.jun.clover.cloverhistory

import com.jun.clover.user.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class CloverHistoryService (private val cloverHistoryRepository: CloverHistoryRepository,
                            private val userRepository: UserRepository) {
    // 클로버 회차 추가
    fun createCloverHistory() = cloverHistoryRepository.save(CloverHistory())

    // 전체 클로버 정보
    fun getCloverHistory() : List<CloverHistory> = cloverHistoryRepository.findAll()

    // 오늘의 클로버 정보 (날짜, 당첨금 등)
    fun getTodayClover() : CloverHistory = cloverHistoryRepository.findCloverHistoryByDateClover(LocalDate.now().toString())

    // 유저 당첨
    @Transactional(rollbackFor = [Exception::class])
    fun weGotWinnerHere(id : String) {
        val prize = getTodayClover().prizeClover // 당첨금
        cloverHistoryRepository.registerWinner(id)  // 당첨자 등록
        userRepository.modifyPoint(id, prize) // 당첨금 주기
        // TODO : 유저 메시지 서비스
    }
}