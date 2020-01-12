package com.jun.clover.entity

import javax.persistence.*

@Entity(name = "cashout_history")
class CashoutHistory (
        @Id
        @Column(name = "cashout_num", insertable=false, updatable=false)
        val cashoutNum : Int,
        val dateCashout : String,
        val idCashout : String,
        val amountCashout : Int
)