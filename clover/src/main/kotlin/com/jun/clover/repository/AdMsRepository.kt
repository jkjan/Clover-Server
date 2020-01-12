package com.jun.clover.repository

import com.jun.clover.entity.AdMs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AdMsRepository : JpaRepository<AdMs, Int> {
}