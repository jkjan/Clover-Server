package com.jun.clover.clovervalid

import com.jun.clover.clovervalid.CloverValid
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CloverValidRepository : JpaRepository<CloverValid, Int> {
}