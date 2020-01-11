package com.jun.clover.service

import com.jun.clover.entity.CloverValid
import com.jun.clover.repository.CloverValidRepository
import org.springframework.stereotype.Service
import java.sql.Time

@Service
class CloverValidService (private val cloverValidRepository: CloverValidRepository) {
    // 사용자가 클로버를 구매
    fun purchaseClover(id : String) {
        cloverValidRepository.save(CloverValid(id))
    }

    // 구매된 클로버 리스트
    fun purchasedCloverList() : List<CloverValid> = cloverValidRepository.findAll()
}