package com.jun.clover.cashouthistory

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CashoutHistoryRepository : JpaRepository<CashoutHistory, Int> {
    fun findCashoutHistoryByIdCashout(idCashout : String) : List<CashoutHistory>
}