package com.jun.clover.entity

import javax.persistence.*

@Entity
class CloverValid(val prcsrId : String) {
        @Id
        @Column(name = "clover_num", insertable = false, updatable = false)
        val cloverNum : Int = 0

        @Column(name = "time", insertable = false, updatable = false)
        val time : String = ""
}