package com.jun.clover.entity

import javax.persistence.*

@Entity(name = "cashout_history")
class CashoutHistory (@Column(name = "id_cashout") val idCashout : String,
                      @Column(name = "amount_cashout") val amountCashout : Int) {
        @Id
        @Column(name = "cashout_num", insertable = false, updatable = false)
        val cashoutNum : Int = 0

        @Column(name = "date_cashout", insertable = false, updatable = false)
        lateinit var dateCashout : String
}