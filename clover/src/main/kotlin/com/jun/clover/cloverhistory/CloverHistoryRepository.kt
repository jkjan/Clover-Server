package com.jun.clover.cloverhistory

import com.jun.clover.cloverhistory.CloverHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import javax.transaction.Transactional

interface CloverHistoryRepository : JpaRepository<CloverHistory, Int> {
    @Modifying
    @Query(value = "update clover_history ch set ch.prizeClover = ch.prizeClover + 10 where ch.dateClover = current_date")
    fun updatePrize() : Int

    // 오늘의 클로버 반환
    fun findCloverHistoryByDateClover(date_clover : String) : CloverHistory

    @Modifying
    @Query(value = "update clover_history ch set ch.idClover = ?1 where ch.dateClover = current_date")
    fun registerWinner(id_winner : String) : Int
}