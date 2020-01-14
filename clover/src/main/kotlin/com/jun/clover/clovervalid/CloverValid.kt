package com.jun.clover.clovervalid

import javax.persistence.*

@Entity(name = "clover_valid")
class CloverValid(@Column(name = "prcsr_id") val prcsrId: String) {
        @Id
        @Column(name = "clover_num", insertable = false, updatable = false)
        val cloverNum : Int = 0

        @Column(name = "time", insertable = false, updatable = false)
        lateinit var time : String
}