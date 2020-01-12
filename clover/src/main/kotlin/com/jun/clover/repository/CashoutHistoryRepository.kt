package com.jun.clover.repository

import com.jun.clover.entity.CashoutHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CashoutHistoryRepository : JpaRepository<CashoutHistory, Int> {
    fun findCashoutHistoryByIdCashout(idCashout : String) : List<CashoutHistory>?
}