package com.jun.clover.variable

enum class Price (private val value : Int) {
    CLOVER(10),

    FRDRECMD(500);

    fun get() = this.value
}