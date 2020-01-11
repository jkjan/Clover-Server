package com.jun.clover.entity

import javax.persistence.*

@Entity
class CloverHistory (
        @Id
        @Column(name = "draw_clover", insertable=false, updatable=false)
        val drawClover : Int,
        val dateClover : String,
        val idClover : String?,
        val prizeClover : Int = 0,
        val ratioClover : Double = 0.0
)