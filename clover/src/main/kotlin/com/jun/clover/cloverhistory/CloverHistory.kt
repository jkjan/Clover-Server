package com.jun.clover.cloverhistory

import javax.persistence.*

@Entity(name = "clover_history")
class CloverHistory() {
        @Id
        @Column(name = "draw_clover", insertable = false, updatable = false)
        val drawClover: Int = 0

        @Column(name = "date_clover", insertable = false, updatable = false)
        lateinit var dateClover: String
        val idClover : String? = null
        var prizeClover: Int = 0
        var ratioClover: Double? = null
}