package com.jun.clover.repository

import com.jun.clover.entity.CloverHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import javax.transaction.Transactional

interface CloverHistoryRepository : JpaRepository<CloverHistory, Int> {
    @Transactional
    @Modifying
    @Query(value = "update clover_history ch set ch.prize_clover = ch.prize_clover + 10 where ch.date_clover = curdate()", nativeQuery = true)
    fun updatePrize() : Int

    // 오늘의 클로버 반환
    fun findCloverHistoryByDateClover(date_clover : String) : CloverHistory
}