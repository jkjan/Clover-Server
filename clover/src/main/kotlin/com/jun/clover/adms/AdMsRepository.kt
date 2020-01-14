package com.jun.clover.adms

import com.jun.clover.adls.AdLs
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface AdMsRepository : JpaRepository<AdLs, Int> {
    @Transactional
    @Modifying
    @Query("select * from ad_ms order by rand() limit 1", nativeQuery = true)
    fun findRandomAdMs() : AdLs
}