package com.jun.clover.repository

import com.jun.clover.entity.CloverValid
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CloverValidRepository : JpaRepository<CloverValid, Int> {

}