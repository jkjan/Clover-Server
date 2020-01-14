package com.jun.clover.adls

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

@Repository
interface AdLsRepository : JpaRepository<AdLs, Int> {
    @Transactional
    @Modifying
    @Query("select * from ad_ls order by rand() limit 1", nativeQuery = true)
    fun findRandomAdLs() : AdLs
}