package com.jun.clover.clovervalid

import com.jun.clover.clovervalid.CloverValid
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface CloverValidRepository : JpaRepository<CloverValid, Int> {
    fun findCloverValidByPrcsrId(id : String) : List<CloverValid>
}