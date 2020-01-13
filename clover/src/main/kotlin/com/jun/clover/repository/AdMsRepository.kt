package com.jun.clover.repository

import com.jun.clover.entity.AdMs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface AdMsRepository : JpaRepository<AdMs, Int> {
    @Transactional
    @Modifying
    @Query("select * from ad_ms order by rand() limit 1", nativeQuery = true)
    fun findRandomAdMs() : AdMs
}